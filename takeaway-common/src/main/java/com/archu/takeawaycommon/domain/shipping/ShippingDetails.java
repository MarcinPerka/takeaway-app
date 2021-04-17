package com.archu.takeawaycommon.domain.shipping;

import com.archu.takeawaycommon.domain.location.Address;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class ShippingDetails {

    @NotNull
    private LocalDateTime shippingTime;

    private ShippingType shippingType;

    @Valid
    @NotNull
    private Address deliveryAddress;
}
