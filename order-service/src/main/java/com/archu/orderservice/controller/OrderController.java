package com.archu.orderservice.controller;

import com.archu.orderservice.domain.Order;
import com.archu.orderservice.service.OrderService;
import com.archu.orderserviceapi.model.OrderRequest;
import com.archu.orderserviceapi.model.OrderResponse;
import com.archu.takeawaycommonspring.apiversion.MediaType;
import com.archu.takeawaycommonspring.exception.types.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_TAKEAWAY_V1_JSON_VALUE)
    public OrderResponse getOrderById(@PathVariable final String id) {
        return orderService.findOrderById(id).orElseThrow(() -> new ResourceNotFoundException(Order.class, "id", id));
    }

    @GetMapping(produces = MediaType.APPLICATION_TAKEAWAY_V1_JSON_VALUE)
    public Page<OrderResponse> getOrders(@RequestParam(defaultValue = "0") final int page,
                                         @RequestParam(defaultValue = "10") final int size,
                                         @RequestParam(defaultValue = "") final List<String> sort) {
        return orderService.findOrders(page, size, sort);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_TAKEAWAY_V1_JSON_VALUE, consumes = MediaType.APPLICATION_TAKEAWAY_V1_JSON_VALUE)
    public OrderResponse updateOrder(@PathVariable final String id, @Valid @RequestBody final OrderRequest orderRequest) {
        return orderService.updateOrder(id, orderRequest);
    }

    @PostMapping(produces = MediaType.APPLICATION_TAKEAWAY_V1_JSON_VALUE, consumes = MediaType.APPLICATION_TAKEAWAY_V1_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse createOrder(@Valid @RequestBody final OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }
}
