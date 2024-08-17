package com.vektorel.kutuphane.service;

import com.vektorel.kutuphane.entity.RentABook;
import com.vektorel.kutuphane.repository.IRentABookRepository;
import com.vektorel.kutuphane.util.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RentABookService extends ServiceManager<RentABook,Long> {
    private final IRentABookRepository repository;

    public RentABookService(IRentABookRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
