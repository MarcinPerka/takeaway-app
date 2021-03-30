package com.archu.takeawaycommon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Location {

    @NotBlank
    private String city;

    @NotNull
    private Country country;

    @Valid
    private Coordinates coordinates;

    @NotBlank
    private String streetAddress;

}
