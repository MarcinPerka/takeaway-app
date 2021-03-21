package com.archu.reviewservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "restaurant-service")
public interface RestaurantClient {


}
