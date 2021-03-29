package com.archu.restaurantserviceapi.dto;

import com.archu.takeawaycommon.dto.Money;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@EqualsAndHashCode
@ToString
public class MenuItem {

    @NotBlank
    private final String name;

    @Valid
    private final Money price;
}
