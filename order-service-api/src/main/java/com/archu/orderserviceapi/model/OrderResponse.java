package com.archu.orderserviceapi.model;

import com.archu.takeawaycommon.domain.payment.PaymentDetails;
import com.archu.takeawaycommon.domain.shipping.ShippingDetails;
import com.archu.takeawaycommonspring.base.domain.BaseResponse;
import lombok.*;

import java.time.Instant;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class OrderResponse extends BaseResponse {

    private String id;

    private Integer version;

    private String name;

    private Instant createdAt;

    private Instant updatedAt;

    private OrderState state;

    private String restaurantId;

    private String customerId;

    private OrderLineItems orderLineItems;

    private PaymentDetails paymentDetails;

    private ShippingDetails shippingDetails;

}
