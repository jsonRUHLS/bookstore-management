package com.ruhlinit.spring_bookstore_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ruhlinit.spring_bookstore_management.data.Publisher;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
