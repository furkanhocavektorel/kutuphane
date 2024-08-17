package com.vektorel.kutuphane.service;

import com.vektorel.kutuphane.entity.Author;
import com.vektorel.kutuphane.repository.IAuthorRepository;
import com.vektorel.kutuphane.util.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthorService extends ServiceManager<Author,Long> {

    private final IAuthorRepository repository;

    public AuthorService(IAuthorRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
