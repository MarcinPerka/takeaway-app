package com.archu.takeawaycommon.dto;

import com.archu.takeawaycommon.dto.Money;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class MenuItem {

    @NotBlank
    private String name;

    @Valid
    private Money price;
}
