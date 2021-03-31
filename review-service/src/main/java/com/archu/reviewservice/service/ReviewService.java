package com.archu.reviewservice.service;

import com.archu.reviewserviceapi.dto.ReviewDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ReviewService {

    ReviewDTO findReviewById(final String id);

    Page<ReviewDTO> findReviewsByRestaurantId(final String restaurantId, final int page, final int size, final List<String> sort);

    ReviewDTO createReview(final ReviewDTO reviewDTO);

    ReviewDTO updateReview(final String id, final ReviewDTO reviewDTO);
}
