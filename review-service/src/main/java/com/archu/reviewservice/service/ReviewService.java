package com.archu.reviewservice.service;

import com.archu.reviewserviceapi.model.ReviewRequest;
import com.archu.reviewserviceapi.model.ReviewResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    Optional<ReviewResponse> findReviewById(final String id);

    Page<ReviewResponse> findReviews(final int page, final int size, final List<String> sort);

    ReviewResponse createReview(final ReviewRequest reviewRequest);

    ReviewResponse updateReview(final String id, final ReviewRequest reviewRequest);
}
