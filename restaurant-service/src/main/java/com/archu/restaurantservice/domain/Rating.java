package com.archu.restaurantservice.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Rating {
    private final int votes;
    private final double score;
}
