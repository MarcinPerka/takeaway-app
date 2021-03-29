package com.archu.takeawaycommon.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@EqualsAndHashCode
@ToString
public class Location {

    @NotBlank
    private final String city;

    @NotNull
    private final Country country;

    @Valid
    private final Coordinates coordinates;

    @NotBlank
    private final String streetAddress;

}
