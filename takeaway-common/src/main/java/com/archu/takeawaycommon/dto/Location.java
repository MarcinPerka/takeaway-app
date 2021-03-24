package com.archu.takeawaycommon.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@EqualsAndHashCode
@ToString
public class Location {

    private final String city;

    private final Country country;

    private final Coordinates coordinates;

    private final String streetAddress;

}
