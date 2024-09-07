package com.vektorel.kutuphane.controller;

import com.vektorel.kutuphane.dto.request.ApprovedBookRQ;
import com.vektorel.kutuphane.dto.request.RentABookSaveRQ;
import com.vektorel.kutuphane.dto.response.RentABookRS;
import com.vektorel.kutuphane.service.RentABookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rent-a-book")
@RequiredArgsConstructor
public class RentABookController {
    private final RentABookService rentABookService;
    @PostMapping("rent")
    public ResponseEntity<?> rentBook(RentABookSaveRQ dto){
     return ResponseEntity.ok(rentABookService.saveRentABook(dto));
    }

    @GetMapping("books-expected-rental-requests/{token}")
    public ResponseEntity<List<RentABookRS>> rentalRequest(@PathVariable("token") String token){
        return ResponseEntity.ok(rentABookService.rentABookListForWait(token));
    }

    @PostMapping("approved-rent")
    public ResponseEntity<?> approvedBook(ApprovedBookRQ dto){
        return ResponseEntity.ok(rentABookService.approvedRent(dto));
    }


}
