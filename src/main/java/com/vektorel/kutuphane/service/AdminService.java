package com.vektorel.kutuphane.service;

import com.vektorel.kutuphane.entity.Admin;
import com.vektorel.kutuphane.repository.IAdminRepository;
import com.vektorel.kutuphane.util.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class AdminService extends ServiceManager<Admin,Long> {

    private final IAdminRepository repository;

    public AdminService (IAdminRepository repository){
        super(repository);
        this.repository=repository;
    }

}
