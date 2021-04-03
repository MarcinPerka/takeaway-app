package com.archu.reviewservice.controller;

import com.archu.reviewservice.service.ReviewService;
import com.archu.reviewserviceapi.dto.ReviewRequest;
import com.archu.reviewserviceapi.dto.ReviewResponse;
import com.archu.takeawaycommonspring.apiversion.MediaType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public Page<ReviewResponse> getReviewsByRestaurantId(@RequestParam final String restaurantId,
                                                    @RequestParam(required = false, defaultValue = "0") final int page,
                                                    @RequestParam(required = false, defaultValue = "10") final int size,
                                                    @RequestParam(required = false, defaultValue = "") final List<String> sort) {
        return reviewService.findReviewsByRestaurantId(restaurantId, page, size, sort);
    }

    @PutMapping("/{id}")
    public ReviewResponse updateReview(@PathVariable final String id, @RequestBody final ReviewRequest reviewRequest) {
        return reviewService.updateReview(id, reviewRequest);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewResponse createReview(@RequestBody final ReviewRequest reviewRequest) {
        return reviewService.createReview(reviewRequest);
    }
}
