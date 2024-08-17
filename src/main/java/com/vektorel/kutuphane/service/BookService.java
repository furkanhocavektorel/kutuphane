package com.vektorel.kutuphane.service;

import com.vektorel.kutuphane.entity.Book;
import com.vektorel.kutuphane.repository.IBookRepository;
import com.vektorel.kutuphane.util.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService extends ServiceManager<Book,Long> {

    private final IBookRepository repository;

    public BookService(IBookRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
