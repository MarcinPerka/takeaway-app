package com.archu.takeawaycommon.domain.location;

import lombok.*;

import javax.validation.Valid;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Location {

    @Valid
    private Address address;

    @Valid
    private Coordinates coordinates;

}
