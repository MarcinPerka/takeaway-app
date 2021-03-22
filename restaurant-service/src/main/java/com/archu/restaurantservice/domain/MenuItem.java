package com.archu.restaurantservice.domain;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@EqualsAndHashCode
@ToString
public class MenuItem {

    private final String id;

    private final String name;

    private final Money price;
}
