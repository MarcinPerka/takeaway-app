package com.archu.reviewservice.service;

import com.archu.reviewservice.domain.Review;

import java.util.Optional;

public interface ReviewService {

    Optional<Review> findReviewById(final String id);

    Iterable<Review> findReviewsByAuthor(final String author);

    Review createReview(final Review review);

    void updateReview(final String id, final Review review);
}
