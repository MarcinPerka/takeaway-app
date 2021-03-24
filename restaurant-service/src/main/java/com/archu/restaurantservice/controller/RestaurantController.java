package com.archu.restaurantservice.controller;

import com.archu.restaurantservice.service.RestaurantService;
import com.archu.restaurantserviceapi.dto.RestaurantDTO;
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
    public Optional<RestaurantDTO> getRestaurantById(@PathVariable String id) {
        return restaurantService.findRestaurantById(id);
    }

    @PutMapping(path = "/{id}")
    public RestaurantDTO updateRestaurant(@PathVariable String id, @RequestBody RestaurantDTO restaurantDTO) {
        return restaurantService.updateRestaurant(id, restaurantDTO);
    }

    @PostMapping
    public RestaurantDTO createRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        return restaurantService.createRestaurant(restaurantDTO);
    }
}
