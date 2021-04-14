package com.archu.orderservice.domain;

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
}
