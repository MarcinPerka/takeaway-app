package com.archu.reviewserviceapi.dto;

import com.archu.takeawaycommonspring.base.domain.BaseRequest;
import lombok.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class ReviewRequest extends BaseRequest {

    private Integer version;

    private String author;

    private String message;

    private int rating;

    private String restaurantId;
}