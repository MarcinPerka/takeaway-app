package com.archu.orderservice.domain;


import com.archu.takeawaycommon.domain.menu.MenuItem;
import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class OrderLineItem {

    private int quantity;

    private MenuItem menuItem;
}
