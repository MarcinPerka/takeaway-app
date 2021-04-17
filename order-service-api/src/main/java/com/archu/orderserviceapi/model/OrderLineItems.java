package com.archu.orderserviceapi.model;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class OrderLineItems {

    @NotNull
    private Set<@Valid OrderLineItem> orderLineItems;
}
