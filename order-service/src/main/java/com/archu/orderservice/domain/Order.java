package com.archu.orderservice.domain;

import com.archu.orderserviceapi.model.OrderLineItems;
import com.archu.orderserviceapi.model.OrderState;
import com.archu.takeawaycommon.domain.payment.PaymentDetails;
import com.archu.takeawaycommon.domain.shipping.ShippingDetails;
import com.archu.takeawaycommonspring.base.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orders")
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@ToString
public class Order extends BaseEntity {

    private OrderState state;

    private String restaurantId;

    private String customerId;

    private OrderLineItems orderLineItems;

    private PaymentDetails paymentDetails;

    private ShippingDetails shippingDetails;
}
