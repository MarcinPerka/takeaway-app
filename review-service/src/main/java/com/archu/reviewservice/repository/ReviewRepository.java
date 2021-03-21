package com.archu.reviewservice.repository;

import com.archu.reviewservice.domain.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {

    Iterable<Review> findReviewsByAuthor(String author);
}
