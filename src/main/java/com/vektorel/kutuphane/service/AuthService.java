package com.vektorel.kutuphane.service;

import com.vektorel.kutuphane.entity.Auth;
import com.vektorel.kutuphane.repository.IAuthRepository;
import com.vektorel.kutuphane.util.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService extends ServiceManager<Auth,Long> {
    private final IAuthRepository repository;

    public AuthService( IAuthRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
