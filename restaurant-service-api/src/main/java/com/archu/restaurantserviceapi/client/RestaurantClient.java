package com.archu.restaurantserviceapi.client;

import com.archu.restaurantserviceapi.dto.RestaurantRequest;
import com.archu.restaurantserviceapi.dto.RestaurantResponse;
import com.querydsl.core.types.Predicate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient("restaurant-service")
public interface RestaurantClient {

    @GetMapping("/{id}")
    RestaurantResponse getRestaurantById(@PathVariable final String id);

    @GetMapping
    Page<RestaurantResponse> getRestaurants(@RequestParam final int page,
                                            @RequestParam final int size,
                                            @RequestParam final List<String> sort,
                                            Predicate predicate);

    @PutMapping("/{id}")
    RestaurantResponse updateRestaurant(@PathVariable final String id, @RequestBody final RestaurantRequest restaurantRequest);

    @PostMapping
    RestaurantResponse createRestaurant(@RequestBody final RestaurantRequest restaurantRequest);
}
