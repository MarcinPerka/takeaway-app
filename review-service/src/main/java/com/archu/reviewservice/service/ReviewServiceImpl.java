package com.archu.reviewservice.service;

import com.archu.reviewservice.converter.ReviewConverter;
import com.archu.reviewservice.repository.ReviewRepository;
import com.archu.reviewserviceapi.model.ReviewRequest;
import com.archu.reviewserviceapi.model.ReviewResponse;
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
    public ReviewResponse findReviewById(final String id) {
        return reviewRepository.findById(id).map(reviewConverter::createFrom)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Restaurant with id %s not found", id)));
    }

    @Override
    public Page<ReviewResponse> findReviews(final int page, final int size, final List<String> sort) {
        final var pageRequest = PagingAndSortingRequest.of(page, size, sort);
        return reviewRepository.findAll(pageRequest).map(reviewConverter::createFrom);
    }

    @Override
    public ReviewResponse createReview(final ReviewRequest reviewRequest) {
        final var review = reviewConverter.createFrom(reviewRequest);
        return reviewConverter.createFrom(reviewRepository.save(review));
    }

    @Override
    public ReviewResponse updateReview(final String id, final ReviewRequest reviewRequest) {
        final var reviewToUpdate = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Review with id %s not found", id)));
        return reviewConverter.createFrom(reviewRepository.save(reviewConverter.updateEntity(reviewToUpdate, reviewRequest)));
    }
}
