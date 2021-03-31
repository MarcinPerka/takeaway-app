package com.archu.reviewservice.controller;

import com.archu.reviewservice.service.ReviewService;
import com.archu.reviewserviceapi.dto.ReviewDTO;
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
    public ReviewDTO getReviewById(@PathVariable final String id) {
        return reviewService.findReviewById(id);
    }


    @GetMapping
    public Page<ReviewDTO> getReviewsByRestaurantId(@RequestParam final String restaurantId,
                                                    @RequestParam(required = false, defaultValue = "0") final int page,
                                                    @RequestParam(required = false, defaultValue = "10") final int size,
                                                    @RequestParam(required = false, defaultValue = "") final List<String> sort) {
        return reviewService.findReviewsByRestaurantId(restaurantId, page, size, sort);
    }

    @PutMapping("/{id}")
    public ReviewDTO updateReview(@PathVariable final String id, @RequestBody final ReviewDTO reviewDTO) {
        return reviewService.updateReview(id, reviewDTO);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReviewDTO createReview(@RequestBody final ReviewDTO reviewDTO) {
        return reviewService.createReview(reviewDTO);
    }
}
