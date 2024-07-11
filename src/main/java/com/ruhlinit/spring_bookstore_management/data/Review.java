package com.ruhlinit.spring_bookstore_management.data;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@Data
public class Review {
    @Id
    private String id;
    private Long bookId;
    private String reviewerName;
    private String comment;
    private int rating;
}
