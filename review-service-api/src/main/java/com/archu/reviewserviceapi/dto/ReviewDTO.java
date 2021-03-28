package com.archu.reviewserviceapi.dto;

import com.archu.takeawaycommonspring.base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@Data
public class ReviewDTO extends BaseDTO {

    private final String id;

    private final Integer version;

    private final String author;

    private final String message;

    private final int rating;

    private final String restaurantId;

}