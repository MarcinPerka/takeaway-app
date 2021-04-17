package com.archu.orderservice.converter;

import com.archu.orderservice.domain.Order;
import com.archu.orderserviceapi.model.OrderRequest;
import com.archu.orderserviceapi.model.OrderResponse;
import com.archu.orderserviceapi.model.OrderState;
import com.archu.takeawaycommonspring.base.domain.BaseConverter;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter implements BaseConverter<OrderRequest, OrderResponse, Order> {
    @Override
    public Order createFrom(OrderRequest dto) {
        return Order.builder()
                .orderLineItems(dto.getOrderLineItems())
                .customerId(dto.getCustomerId())
                .restaurantId(dto.getRestaurantId())
                .paymentDetails(dto.getPaymentDetails())
                .shippingDetails(dto.getShippingDetails())
                .state(OrderState.APPROVAL_PENDING)
                .build();
    }

    @Override
    public OrderResponse createFrom(Order entity) {
        return OrderResponse.builder()
                .id(entity.getId())
                .version(entity.getVersion())
                .orderLineItems(entity.getOrderLineItems())
                .customerId(entity.getCustomerId())
                .restaurantId(entity.getRestaurantId())
                .paymentDetails(entity.getPaymentDetails())
                .shippingDetails(entity.getShippingDetails())
                .state(entity.getState())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    @Override
    public Order updateEntity(Order entity, OrderRequest dto) {
        return entity.toBuilder()
                .version(dto.getVersion())
                .orderLineItems(dto.getOrderLineItems())
                .customerId(dto.getCustomerId())
                .restaurantId(dto.getRestaurantId())
                .paymentDetails(dto.getPaymentDetails())
                .shippingDetails(dto.getShippingDetails())
                .state(dto.getState())
                .build();
    }
}
