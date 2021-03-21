package com.archu.reviewservice.service;

import com.archu.reviewservice.domain.Review;
import com.archu.reviewservice.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public Optional<Review> findReviewById(String id) {
        return reviewRepository.findById(id);
    }

    @Override
    public Iterable<Review> findReviewsByAuthor(String author) {
        return reviewRepository.findReviewsByAuthor(author);
    }

    @Override
    public Review createReview(Review review) {
        return null;
    }

    @Override
    public void updateReview(String id, Review review) {

    }
}
