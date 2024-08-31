package com.vektorel.kutuphane.service;

import com.vektorel.kutuphane.dto.request.ApprovedBookRQ;
import com.vektorel.kutuphane.dto.request.RentABookSaveRQ;
import com.vektorel.kutuphane.dto.response.RentABookRS;
import com.vektorel.kutuphane.entity.*;
import com.vektorel.kutuphane.entity.enums.BookApprov;
import com.vektorel.kutuphane.entity.enums.Role;
import com.vektorel.kutuphane.exception.AllException;
import com.vektorel.kutuphane.exception.custom.*;
import com.vektorel.kutuphane.repository.IRentABookRepository;
import com.vektorel.kutuphane.util.JwtManager;
import com.vektorel.kutuphane.util.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RentABookService extends ServiceManager<RentABook,Long> {
    private final IRentABookRepository repository;
    private final JwtManager jwtManager;
    private final CustomerService customerService;
    private final AdminService adminService;
    private final BookService bookService;

    private final AuthService authService;

    // TODO kitap isteği reddetme yapılacak
    // TODO kullanıcı kendi talep ettiği kitapları görmeli
    // TODO kullanıcı bilgilerini güncellemeli

    // TODO kitap hangi şehirde bulunuyor kullanıcı hangi şehirden talep ediyor
    // farklı şehirlerde ise otomatik reddedilsin
    public RentABookService(IRentABookRepository repository, JwtManager jwtManager, CustomerService customerService, AdminService adminService, BookService bookService, AuthService authService) {
        super(repository);
        this.repository = repository;
        this.jwtManager = jwtManager;
        this.customerService = customerService;
        this.adminService = adminService;
        this.bookService = bookService;
        this.authService = authService;
    }

    public Boolean saveRentABook(RentABookSaveRQ dto){
        Long authId= jwtManager.validToken(dto.getToken()).orElseThrow(()->new TokenException(AllException.TOKEN_ERROR));
        Customer customer=customerService.findByAuthId(authId).orElseThrow(()-> new CustomerException(AllException.CUSTOMER_NOT_FOUND));

        if (!bookService.existsById(dto.getBookId())){
            throw new BookException(AllException.BOOK_NOT_FOUND);
        }

        RentABook rentABook= RentABook.builder()
                .bookId(dto.getBookId())
                .rentDate(new Date().toString())
                .approv(BookApprov.WAIT)
                .customerId(customer.getId())
                .rentalPeriod(dto.getRentalPeriod())
                .build();
        save(rentABook);

        return true;
    }



    public List<RentABookRS> rentABookListForWait(String token){
        Long authId= jwtManager.validToken(token).orElseThrow(()-> new TokenException(AllException.TOKEN_ERROR));

        Auth auth=authService.findById(authId).orElseThrow(()-> new AuthException(AllException.DEFAULT_EXCEPTION));
        if (!auth.getRole().equals(Role.ADMIN) && !auth.getRole().equals(Role.SUPERADMIN)){
            throw new AuthException(AllException.NOT_AUTHORIZE);
        }
        // bu kod daha yavas calisir cünkü:
        // database de ki tüm tabloyu getirip daha sonra wait kısıtlaması yapar
        // 100 bin kaydı cekmek uzun sürebilir.
        //List<RentABook> rentABooks= (List<RentABook>) findAll().stream().filter(x->x.getApprov()==BookApprov.WAIT);

        List<RentABook> rentABooks=repository.findByApprov(BookApprov.WAIT);

        List<RentABookRS> responses= new ArrayList<>();

        for (RentABook rentABook: rentABooks){

            Book book= bookService.findById(rentABook.getBookId()).orElseThrow(()->new BookException(AllException.BOOK_NOT_FOUND));
            Customer customer= customerService.findById(rentABook.getCustomerId()).orElseThrow(()-> new CustomerException(AllException.CUSTOMER_NOT_FOUND));

            responses.add(RentABookRS.builder()
                            .rentDate(rentABook.getRentDate())
                            .bookId(rentABook.getBookId())
                            .customerId(rentABook.getCustomerId())
                            .rentalPeriod(rentABook.getRentalPeriod())
                            .bookName(book.getName())
                            .ISBN(book.getISBN())
                            .stock(book.getStock())
                            .pageCount(book.getPageCount())
                            .customerName(customer.getName())
                            .customerSurname(customer.getSurname())
                            .rentId(rentABook.getId())
                    .build());

        }

        return responses;
    }


    // token,rentabookId,book stock ları düzenlenmeli
    public boolean approvedRent(ApprovedBookRQ dto){
        Long authId= jwtManager.validToken(dto.getToken()).orElseThrow(()->new TokenException(AllException.TOKEN_ERROR));
        Auth auth= authService.findById(authId).orElseThrow(()->new AuthException(AllException.DEFAULT_EXCEPTION));

        if (auth.getRole().equals(Role.CUSTOMER)){
            throw new AuthException(AllException.NOT_AUTHORIZE);
        }

        // Book Exception fırlatılmamalı
        // rentabook exception dan bu kiralama isteği bulunamadı hatası fırlatılmalı
        // bunu için rentabook exception yazılmalı
        RentABook rentABook= findById(dto.getRentABookId()).orElseThrow(()-> new BookException(AllException.BOOK_NOT_FOUND));

        Book book= bookService.findById(rentABook.getBookId()).orElseThrow(()-> new BookException(AllException.BOOK_NOT_FOUND));
        Admin admin= adminService.findByAuthId(auth.getId()).orElseThrow(()-> new AdminException(AllException.ADMIN_NOT_FOUND));

        rentABook.setApprov(BookApprov.APPROVED);
        rentABook.setAdminId(admin.getId());
        update(rentABook);

        book.setStock(book.getStock()-1);
        bookService.update(book);
        return true;
    }

}
