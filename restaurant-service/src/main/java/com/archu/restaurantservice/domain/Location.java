package com.archu.restaurantservice.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Location {

    private final String city;
    private final Country country;
    private final Coordinates coordinates;
    private final String streetAddress;

}
