package com.archu.orderservice.domain;

import lombok.*;

import java.util.Set;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class OrderLineItems {

    private Set<OrderLineItem> orderLineItems;
}
