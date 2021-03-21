package com.archu.restaurantservice.controller;

import com.archu.restaurantservice.domain.Restaurant;
import com.archu.restaurantservice.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping(path = "/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable String id) {
        return restaurantService.findRestaurantById(id);
    }

    @PutMapping(path = "/{id}")
    public void updateRestaurant(@PathVariable String id, @RequestBody Restaurant restaurant) {
        restaurantService.updateRestaurant(id, restaurant);
    }

    @PostMapping
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.createRestaurant(restaurant);
    }
}
