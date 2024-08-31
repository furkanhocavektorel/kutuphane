package com.vektorel.kutuphane.repository;

import com.vektorel.kutuphane.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findOptionalByAuthId(Long authId);
}
