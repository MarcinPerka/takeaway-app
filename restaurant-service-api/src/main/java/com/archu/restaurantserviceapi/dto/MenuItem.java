package com.archu.restaurantserviceapi.dto;

import com.archu.takeawaycommon.dto.Money;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class MenuItem {

    @NotBlank
    private final String name;

    @Valid
    private final Money price;
}
