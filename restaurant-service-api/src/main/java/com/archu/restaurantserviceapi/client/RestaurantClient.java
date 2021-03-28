package com.archu.restaurantserviceapi.client;

import com.archu.restaurantserviceapi.dto.RestaurantDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("restaurant-service")
public interface RestaurantClient {

    @GetMapping(path = "/{id}")
    RestaurantDTO getRestaurantById(@PathVariable final String id);

    @PutMapping(path = "/{id}")
    RestaurantDTO updateRestaurant(@PathVariable String id, @RequestBody final RestaurantDTO restaurant);

    @PostMapping
    RestaurantDTO createRestaurant(@RequestBody final RestaurantDTO restaurant);

}
