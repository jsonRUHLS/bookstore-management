package com.ruhlinit.spring_bookstore_management.repositories;

import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ruhlinit.spring_bookstore_management.data.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @SuppressWarnings("null")
    @Override
    @Cacheable("books")
    Optional<Book> findById(Long id);

}
