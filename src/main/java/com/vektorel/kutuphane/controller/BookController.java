package com.vektorel.kutuphane.controller;

import com.vektorel.kutuphane.dto.request.BookSaveRQRecord;
import com.vektorel.kutuphane.dto.response.BookResponse;
import com.vektorel.kutuphane.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("list/{token}")
    public ResponseEntity<List<BookResponse>> getBooks(@PathVariable(required = false) String token){
        return ResponseEntity.ok(bookService.bookList(token));
    }

    @PostMapping("save")
    public ResponseEntity<BookResponse> saveBook(@RequestBody BookSaveRQRecord dto){
        return ResponseEntity.ok(bookService.saveBook(dto));
    }





}
