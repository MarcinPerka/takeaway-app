package com.archu.reviewserviceapi.dto;

import com.archu.takeawaycommonspring.base.domain.BaseResponse;
import lombok.*;

import java.time.Instant;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class ReviewResponse extends BaseResponse {

    private String id;

    private Integer version;

    private String author;

    private String message;

    private int rating;

    private String restaurantId;

    private Instant createdAt;

    private Instant updatedAt;

}