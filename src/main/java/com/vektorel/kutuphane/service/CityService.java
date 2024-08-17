package com.vektorel.kutuphane.service;

import com.vektorel.kutuphane.entity.City;
import com.vektorel.kutuphane.repository.ICityRepository;
import com.vektorel.kutuphane.util.ServiceManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CityService  {

    private final ICityRepository repository;

    public CityService(ICityRepository repository) {
        this.repository = repository;
    }
}
