package com.archu.takeawaycommon.domain.location;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Location {

    @Valid
    @NotNull
    private Address address;

    @Valid
    @NotNull
    private Coordinates coordinates;

}
