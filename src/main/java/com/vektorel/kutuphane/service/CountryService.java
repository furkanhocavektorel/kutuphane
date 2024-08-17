package com.vektorel.kutuphane.service;

import com.vektorel.kutuphane.repository.ICountryRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    private final ICountryRepository repository;

    public CountryService(ICountryRepository repository) {
        this.repository = repository;
    }
}
