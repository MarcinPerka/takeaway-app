package com.archu.restaurantserviceapi.dto;

import com.archu.takeawaycommon.dto.Money;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Getter
@RequiredArgsConstructor
@ToString
public class MenuItem {

    @NotBlank
    private final String name;

    @Valid
    private final Money price;
}
