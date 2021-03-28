package com.archu.reviewservice.controller;

import com.archu.reviewservice.service.ReviewService;
import com.archu.reviewserviceapi.dto.ReviewDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping(path = "/{id}")
    public ReviewDTO getReviewById(@PathVariable final String id) {
        return reviewService.findReviewById(id);
    }

    @GetMapping
    public Iterable<ReviewDTO> getReviewsById(@RequestParam final String author) {
        return reviewService.findReviewsByAuthor(author);
    }

    @PutMapping(path = "/{id}")
    public ReviewDTO updateReview(@PathVariable final String id, @RequestBody final ReviewDTO reviewDTO) {
        return reviewService.updateReview(id, reviewDTO);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewDTO createReview(@RequestBody final ReviewDTO reviewDTO) {
        return reviewService.createReview(reviewDTO);
    }
}
