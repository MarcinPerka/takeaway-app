package com.archu.reviewserviceapi.client;


import com.archu.reviewserviceapi.dto.ReviewRequest;
import com.archu.reviewserviceapi.dto.ReviewResponse;
import com.querydsl.core.types.Predicate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("review-service")
public interface ReviewClient {

    @GetMapping("/{id}")
    ReviewResponse getReviewById(@PathVariable final String id);

    @GetMapping
    Page<ReviewResponse> getReviews(@RequestParam final int page,
                                    @RequestParam final int size,
                                    @RequestParam final List<String> sort);

    @PutMapping("/{id}")
    ReviewResponse updateReview(@PathVariable final String id, @RequestBody final ReviewRequest reviewRequest);

    @PostMapping
    ReviewResponse createReview(@RequestBody final ReviewRequest reviewRequest);

}
