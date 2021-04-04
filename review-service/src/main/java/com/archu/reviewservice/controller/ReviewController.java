package com.archu.reviewservice.controller;

import com.archu.reviewservice.domain.Review;
import com.archu.reviewservice.repository.ReviewRepository;
import com.archu.reviewservice.service.ReviewService;
import com.archu.reviewserviceapi.dto.ReviewRequest;
import com.archu.reviewserviceapi.dto.ReviewResponse;
import com.archu.takeawaycommonspring.apiversion.MediaType;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_TAKEAWAY_V1_JSON_VALUE, consumes = MediaType.APPLICATION_TAKEAWAY_V1_JSON_VALUE)
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/{id}")
    public ReviewResponse getReviewById(@PathVariable final String id) {
        return reviewService.findReviewById(id);
    }


    @GetMapping
    public Page<ReviewResponse> getReviews(@RequestParam(defaultValue = "0") final int page,
                                           @RequestParam(defaultValue = "10") final int size,
                                           @RequestParam(defaultValue = "") final List<String> sort,
                                           @QuerydslPredicate(root = Review.class, bindings = ReviewRepository.class) final Predicate predicate) {
        return reviewService.findReviews(page, size, sort, predicate);
    }

    @PutMapping("/{id}")
    public ReviewResponse updateReview(@PathVariable final String id, @Valid @RequestBody final ReviewRequest reviewRequest) {
        return reviewService.updateReview(id, reviewRequest);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewResponse createReview(@Valid @RequestBody final ReviewRequest reviewRequest) {
        return reviewService.createReview(reviewRequest);
    }
}
