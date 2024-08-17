package com.vektorel.kutuphane.repository;

import com.vektorel.kutuphane.entity.RentABook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRentABookRepository extends JpaRepository<RentABook,Long> {
}
