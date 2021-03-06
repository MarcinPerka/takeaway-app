package com.archu.reviewservice.controller;

import com.archu.reviewservice.domain.Review;
import com.archu.reviewservice.service.ReviewService;
import com.archu.reviewserviceapi.model.ReviewRequest;
import com.archu.reviewserviceapi.model.ReviewResponse;
import com.archu.takeawaycommonspring.apiversion.MediaType;
import com.archu.takeawaycommonspring.exception.types.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_TAKEAWAY_V1_JSON_VALUE)
    public ReviewResponse getReviewById(@PathVariable final String id) {
        return reviewService.findReviewById(id).orElseThrow(() -> new ResourceNotFoundException(Review.class, "id", id));
    }


    @GetMapping(produces = MediaType.APPLICATION_TAKEAWAY_V1_JSON_VALUE)
    public Page<ReviewResponse> getReviews(@RequestParam(defaultValue = "0") final int page,
                                           @RequestParam(defaultValue = "10") final int size,
                                           @RequestParam(defaultValue = "") final List<String> sort) {
        return reviewService.findReviews(page, size, sort);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_TAKEAWAY_V1_JSON_VALUE, consumes = MediaType.APPLICATION_TAKEAWAY_V1_JSON_VALUE)
    public ReviewResponse updateReview(@PathVariable final String id, @Valid @RequestBody final ReviewRequest reviewRequest) {
        return reviewService.updateReview(id, reviewRequest);
    }

    @PostMapping(produces = MediaType.APPLICATION_TAKEAWAY_V1_JSON_VALUE, consumes = MediaType.APPLICATION_TAKEAWAY_V1_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewResponse createReview(@Valid @RequestBody final ReviewRequest reviewRequest) {
        return reviewService.createReview(reviewRequest);
    }
}
