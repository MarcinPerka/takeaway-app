package com.archu.orderserviceapi.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("order-service")
public interface OrderClient {
}
