package com.archu.orderservice.service;

import com.archu.orderservice.converter.OrderConverter;
import com.archu.orderservice.repository.OrderRepository;
import com.archu.orderserviceapi.model.OrderRequest;
import com.archu.orderserviceapi.model.OrderResponse;
import com.archu.takeawaycommonspring.base.page.PagingAndSortingRequest;
import com.archu.takeawaycommonspring.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final OrderConverter orderConverter;

    @Override
    public OrderResponse findOrderById(final String id) {
        return orderRepository.findById(id).map(orderConverter::createFrom)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Order with id %s not found", id)));
    }

    @Override
    public Page<OrderResponse> findOrders(final int page, final int size, final List<String> sort) {
        final var pageRequest = PagingAndSortingRequest.of(page, size, sort);
        return orderRepository.findAll(pageRequest).map(orderConverter::createFrom);
    }

    @Override
    public OrderResponse createOrder(final OrderRequest orderRequest) {
        final var order = orderConverter.createFrom(orderRequest);
        return orderConverter.createFrom(orderRepository.save(order));
    }

    @Override
    public OrderResponse updateOrder(final String id, final OrderRequest orderRequest) {
        final var orderToUpdate = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Order with id %s not found", id)));
        return orderConverter.createFrom(orderRepository.save(orderConverter.updateEntity(orderToUpdate, orderRequest)));
    }
}
