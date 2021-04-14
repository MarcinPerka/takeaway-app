package com.archu.takeawaycommon.domain.shipping;

import com.archu.takeawaycommon.domain.location.Address;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class ShippingDetails {

    private LocalDateTime shippingTime;

    private ShippingType shippingType;

    private Address deliveryAddress;
}
