package com.archu.takeawaycommon.domain.menu;

import com.archu.takeawaycommon.domain.general.Money;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class MenuItem {

    @NotBlank
    private String name;

    @Valid
    @NotNull
    private Money price;
}
