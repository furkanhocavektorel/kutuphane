package com.vektorel.kutuphane.service;

import com.vektorel.kutuphane.entity.Book_Author;
import com.vektorel.kutuphane.repository.IBook_AuthorRepository;
import com.vektorel.kutuphane.util.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class Book_AuthorService {

    private final IBook_AuthorRepository repository;

    public Book_AuthorService(IBook_AuthorRepository repository) {
        this.repository = repository;
    }
}
