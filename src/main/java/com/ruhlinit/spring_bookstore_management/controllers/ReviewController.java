package com.ruhlinit.spring_bookstore_management.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruhlinit.spring_bookstore_management.data.Review;
import com.ruhlinit.spring_bookstore_management.repositories.ReviewRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewRepository reviewRepository;

    @PostMapping
    public ResponseEntity<Review> addReview(@RequestBody Review review) {
        Review savedReview = reviewRepository.save(review);
        return ResponseEntity.ok(savedReview);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReview(@PathVariable String id) {
        Optional<Review> review = reviewRepository.findById(id);
        return review.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Review> updateReview(@PathVariable String id, @RequestBody Review reviewDetails) {
        return reviewRepository.findById(id)
                .map(existingReview -> {
                    existingReview.setBookId(reviewDetails.getBookId());
                    existingReview.setReviewerName(reviewDetails.getReviewerName());
                    existingReview.setComment(reviewDetails.getComment());
                    existingReview.setRating(reviewDetails.getRating());
                    Review updatedReview = reviewRepository.save(existingReview);
                    return ResponseEntity.ok(updatedReview);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteReview(@PathVariable String id) {
        return reviewRepository.findById(id)
                .map(review -> {
                    reviewRepository.delete(review);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
