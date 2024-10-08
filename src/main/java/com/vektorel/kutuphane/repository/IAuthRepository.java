package com.vektorel.kutuphane.repository;

import com.vektorel.kutuphane.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAuthRepository extends JpaRepository<Auth,Long> {

    boolean existsByEmailOrUsername(String email,String username);
    Optional<Auth> findOptionalByEmailOrUsername(String email,String username);
}
