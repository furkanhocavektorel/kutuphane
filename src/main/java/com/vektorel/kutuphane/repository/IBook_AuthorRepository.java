package com.vektorel.kutuphane.repository;

import com.vektorel.kutuphane.entity.Book_Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBook_AuthorRepository extends JpaRepository<Book_Author,Long> {
}
