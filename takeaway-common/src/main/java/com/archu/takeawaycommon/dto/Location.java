package com.archu.takeawaycommon.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
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
