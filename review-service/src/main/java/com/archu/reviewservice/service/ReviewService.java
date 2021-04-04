package com.archu.reviewservice.service;

import com.archu.reviewserviceapi.dto.ReviewRequest;
import com.archu.reviewserviceapi.dto.ReviewResponse;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ReviewService {

    ReviewResponse findReviewById(final String id);

    Page<ReviewResponse> findReviews(final int page, final int size, final List<String> sort, final Predicate predicate);

    ReviewResponse createReview(final ReviewRequest reviewRequest);

    ReviewResponse updateReview(final String id, final ReviewRequest reviewRequest);
}
