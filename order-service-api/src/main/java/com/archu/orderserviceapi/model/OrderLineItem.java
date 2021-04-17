package com.archu.orderserviceapi.model;


import com.archu.takeawaycommon.domain.menu.MenuItem;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class OrderLineItem {

    @Positive
    private int quantity;

    @Valid
    @NotNull
    private MenuItem menuItem;
}
