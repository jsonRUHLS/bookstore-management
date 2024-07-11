package com.ruhlinit.spring_bookstore_management.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ruhlinit.spring_bookstore_management.data.Review;

public interface ReviewRepository extends MongoRepository<Review, String> {

}
