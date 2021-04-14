package com.archu.orderservice.converter;

import com.archu.orderservice.domain.Order;
import com.archu.orderserviceapi.dto.OrderRequest;
import com.archu.orderserviceapi.dto.OrderResponse;
import com.archu.takeawaycommonspring.base.domain.BaseConverter;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter implements BaseConverter<OrderRequest, OrderResponse, Order> {
    @Override
    public Order createFrom(OrderRequest dto) {
        return null;
    }

    @Override
    public OrderResponse createFrom(Order entity) {
        return null;
    }

    @Override
    public Order updateEntity(Order entity, OrderRequest dto) {
        return null;
    }
}
