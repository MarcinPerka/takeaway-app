package com.archu.restaurantserviceapi.client;

import com.archu.restaurantserviceapi.dto.RestaurantDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient
public interface RestaurantClient {

    @GetMapping(path = "/{id}")
    Optional<RestaurantDTO> getRestaurantById(@PathVariable final String id);

    @PutMapping(path = "/{id}")
    void updateRestaurant(@PathVariable String id, @RequestBody final RestaurantDTO restaurant);

    @PostMapping
    RestaurantDTO createRestaurant(@RequestBody final RestaurantDTO restaurant);

}
