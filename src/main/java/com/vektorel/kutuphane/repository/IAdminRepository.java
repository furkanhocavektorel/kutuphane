package com.vektorel.kutuphane.repository;

import com.vektorel.kutuphane.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAdminRepository extends JpaRepository<Admin,Long> {

    Optional<Admin> findByAuthId(Long authId);
}
