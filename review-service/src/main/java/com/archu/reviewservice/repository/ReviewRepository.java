package com.archu.reviewservice.repository;

import com.archu.reviewservice.domain.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {

    List<Review> findReviewsByAuthor(String author);

    Page<Review> findReviewsByRestaurantId(String restaurantId, Pageable pageable);
}
