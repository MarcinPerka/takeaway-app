package com.archu.reviewservice.controller;

import com.archu.reviewservice.domain.Review;
import com.archu.reviewservice.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping(path = "/{id}")
    public Optional<Review> getReviewById(@PathVariable String id) {
        return reviewService.findReviewById(id);
    }

    @GetMapping
    public Iterable<Review> getReviewsById(@RequestParam String author) {
        return reviewService.findReviewsByAuthor(author);
    }

    @PutMapping(path = "/{id}")
    public void updateReview(@PathVariable String id, @RequestBody Review review) {
        reviewService.updateReview(id, review);
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewService.createReview(review);
    }
}
