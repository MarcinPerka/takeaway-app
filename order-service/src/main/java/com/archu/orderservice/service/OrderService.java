package com.archu.orderservice.service;

import com.archu.orderserviceapi.model.OrderRequest;
import com.archu.orderserviceapi.model.OrderResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderService {

    OrderResponse findOrderById(final String id);

    Page<OrderResponse> findOrders(final int page, final int size, final List<String> sort);

    OrderResponse createOrder(final OrderRequest orderRequest);

    OrderResponse updateOrder(final String id, final OrderRequest orderRequest);
}
