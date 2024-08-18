package com.vektorel.kutuphane.service;

import com.vektorel.kutuphane.dto.request.CustomerSaveRQ;
import com.vektorel.kutuphane.entity.Customer;
import com.vektorel.kutuphane.mapper.ICustomerMapper;
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

    public void saveCustomer(CustomerSaveRQ dto,Long authId){
        Customer customer= ICustomerMapper.INSTANCE.toCustomer(dto);
        customer.setAuthId(authId);
        save(customer);
    }



}
