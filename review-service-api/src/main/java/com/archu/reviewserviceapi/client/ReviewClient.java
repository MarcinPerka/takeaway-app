package com.archu.reviewserviceapi.client;


import com.archu.reviewserviceapi.dto.ReviewDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("review-service")
public interface ReviewClient {

    @GetMapping(path = "/{id}")
    ReviewDTO getReviewById(@PathVariable final String id);

    @GetMapping
    List<ReviewDTO> getReviewsById(@RequestParam final String author);

    @PutMapping(path = "/{id}")
    ReviewDTO updateReview(@PathVariable final String id, @RequestBody final ReviewDTO reviewDTO);

    @PostMapping
    ReviewDTO createReview(@RequestBody final ReviewDTO reviewDTO);

}
