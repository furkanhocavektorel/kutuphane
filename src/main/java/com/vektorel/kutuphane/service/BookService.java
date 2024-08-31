package com.vektorel.kutuphane.service;

import com.vektorel.kutuphane.dto.request.BookSaveRQRecord;
import com.vektorel.kutuphane.dto.response.BookResponse;
import com.vektorel.kutuphane.entity.Auth;
import com.vektorel.kutuphane.entity.Book;
import com.vektorel.kutuphane.entity.enums.Role;
import com.vektorel.kutuphane.exception.AllException;
import com.vektorel.kutuphane.exception.custom.AuthException;
import com.vektorel.kutuphane.exception.custom.TokenException;
import com.vektorel.kutuphane.mapper.IBookMapper;
import com.vektorel.kutuphane.repository.IAuthRepository;
import com.vektorel.kutuphane.repository.IBookRepository;
import com.vektorel.kutuphane.util.JwtManager;
import com.vektorel.kutuphane.util.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService extends ServiceManager<Book,Long> {
    private final IBookRepository repository;
    private final JwtManager jwtManager;
    private final AuthService authService;

    public BookService(IBookRepository repository, JwtManager jwtManager, AuthService authService) {
        super(repository);
        this.repository = repository;
        this.jwtManager = jwtManager;
        this.authService = authService;
    }

    // C.R.U.D


    public List<BookResponse> bookList(String token){
        List<BookResponse> responses= new ArrayList<>();

        List<Book> books= findAll();

        if (token==null || token.isBlank()){
            for (Book book : books.subList(0,10)){
                responses.add(IBookMapper.INSTANCE.toDto(book));
            }
        }else {
            Optional<Long> id=jwtManager.validToken(token);

            if (id.isEmpty()){
                throw new TokenException(AllException.TOKEN_ERROR);
            }

            for (Book book : books){
                responses.add(IBookMapper.INSTANCE.toDto(book));
            }

        }

        return responses;
    }


    // kitap kayıt işlemi sadece admin kayıt edebilir
    public BookResponse saveBook(BookSaveRQRecord dto){

        // dto icinde ki token dan auth un rolü gerekiyor.
        Long authId = jwtManager.validToken(dto.token()).orElseThrow(()-> new TokenException(AllException.TOKEN_ERROR));
        Auth auth= authService.findById(authId).orElseThrow(()-> new AuthException(AllException.ADMIN_NOT_FOUND));

        if (!auth.getRole().equals(Role.ADMIN) && !auth.getRole().equals(Role.SUPERADMIN)){
            throw new AuthException(AllException.NOT_AUTHORIZE);
        }

        Book book=save(IBookMapper.INSTANCE.toBook(dto));
        return IBookMapper.INSTANCE.toDto(book);
    }


    public boolean existsById(Long bookId){
        return repository.existsById(bookId);
    }

}
