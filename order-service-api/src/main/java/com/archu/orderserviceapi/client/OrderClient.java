package com.archu.orderserviceapi.client;

import com.archu.orderserviceapi.model.OrderRequest;
import com.archu.orderserviceapi.model.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("order-service")
public interface OrderClient {

    @GetMapping("/{id}")
    OrderResponse getOrderById(@PathVariable final String id);

    @GetMapping
    Page<OrderResponse> getOrders(@RequestParam final int page,
                                  @RequestParam final int size,
                                  @RequestParam final List<String> sort);

    @PutMapping("/{id}")
    OrderResponse updateOrder(@PathVariable final String id, @RequestBody final OrderRequest orderRequest);

    @PostMapping
    OrderResponse createOrder(@RequestBody final OrderRequest orderRequest);

}
