package com.vektorel.kutuphane.service;

import com.vektorel.kutuphane.entity.Customer;
import com.vektorel.kutuphane.repository.ICustomerRepository;
import com.vektorel.kutuphane.util.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService extends ServiceManager<Customer,Long> {

    private final ICustomerRepository repository;

    public CustomerService(ICustomerRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
