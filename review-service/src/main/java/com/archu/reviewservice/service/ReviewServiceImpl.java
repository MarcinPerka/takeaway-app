package com.archu.reviewservice.service;

import com.archu.reviewservice.converter.ReviewConverter;
import com.archu.reviewservice.repository.ReviewRepository;
import com.archu.reviewserviceapi.dto.ReviewDTO;
import com.archu.takeawaycommonspring.base.page.PagingAndSortingRequest;
import com.archu.takeawaycommonspring.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final ReviewConverter reviewConverter;

    @Override
    public ReviewDTO findReviewById(final String id) {
        return reviewRepository.findById(id).map(reviewConverter::createFrom)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Restaurant with id %s not found", id)));
    }

    @Override
    public Page<ReviewDTO> findReviewsByRestaurantId(final String restaurantId, final int page, final int size, final List<String> sort) {
        final var pageRequest = PagingAndSortingRequest.of(page, size, sort);
        return reviewRepository.findReviewsByRestaurantId(restaurantId, pageRequest).map(reviewConverter::createFrom);
    }

    @Override
    public ReviewDTO createReview(final ReviewDTO reviewDTO) {
        final var review = reviewConverter.createFrom(reviewDTO);
        return reviewConverter.createFrom(reviewRepository.save(review));
    }

    @Override
    public ReviewDTO updateReview(final String id, final ReviewDTO reviewDTO) {
        final var reviewToUpdate = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Review with id %s not found", id)));
        return reviewConverter.createFrom(reviewRepository.save(reviewConverter.updateEntity(reviewToUpdate, reviewDTO)));
    }
}
