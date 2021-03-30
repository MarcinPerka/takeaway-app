package com.archu.restaurantserviceapi.dto;

import com.archu.takeawaycommon.dto.Money;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MenuItem {

    @NotBlank
    private String name;

    @Valid
    private Money price;
}
