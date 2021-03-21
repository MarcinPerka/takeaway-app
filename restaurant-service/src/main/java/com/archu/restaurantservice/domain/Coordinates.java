package com.archu.restaurantservice.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Coordinates {

    private final double latitude;
    private final double longitude;
}
