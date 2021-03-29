package com.archu.takeawaycommon.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
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
