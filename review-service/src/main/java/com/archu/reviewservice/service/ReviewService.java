package com.archu.reviewservice.service;

import com.archu.reviewserviceapi.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {

    ReviewDTO findReviewById(final String id);

    List<ReviewDTO> findReviewsByAuthor(final String author);

    ReviewDTO createReview(final ReviewDTO reviewDTO);

    ReviewDTO updateReview(final String id, final ReviewDTO reviewDTO);
}
