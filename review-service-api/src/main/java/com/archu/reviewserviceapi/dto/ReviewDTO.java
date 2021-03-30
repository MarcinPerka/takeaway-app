package com.archu.reviewserviceapi.dto;

import com.archu.takeawaycommonspring.base.BaseDTO;
import lombok.*;

import java.time.Instant;

@Builder
@RequiredArgsConstructor
@Getter
@ToString
public class ReviewDTO extends BaseDTO {

    private final String id;

    private final Integer version;

    private final String author;

    private final String message;

    private final int rating;

    private final String restaurantId;

    private final Instant createdAt;

    private final Instant updatedAt;

}