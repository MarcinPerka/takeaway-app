package com.archu.restaurantserviceapi.dto;

import com.archu.takeawaycommon.dto.Money;
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
