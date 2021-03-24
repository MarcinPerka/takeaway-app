package com.archu.restaurantserviceapi.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Builder
@EqualsAndHashCode
@ToString
public class Rating {
    private final int votes;
    private final BigDecimal score;
}
