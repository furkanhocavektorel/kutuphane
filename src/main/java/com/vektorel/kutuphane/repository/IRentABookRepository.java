package com.vektorel.kutuphane.repository;

import com.vektorel.kutuphane.entity.RentABook;
import com.vektorel.kutuphane.entity.enums.BookApprov;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRentABookRepository extends JpaRepository<RentABook,Long> {

    List<RentABook> findByApprov(BookApprov approv);
}
