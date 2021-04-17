package com.archu.orderservice.service;

import com.archu.orderserviceapi.model.OrderRequest;
import com.archu.orderserviceapi.model.OrderResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Optional<OrderResponse> findOrderById(final String id);

    Page<OrderResponse> findOrders(final int page, final int size, final List<String> sort);

    OrderResponse createOrder(final OrderRequest orderRequest);

    OrderResponse updateOrder(final String id, final OrderRequest orderRequest);
}
