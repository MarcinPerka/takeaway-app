package com.archu.restaurantservice.controller;

import com.archu.restaurantservice.service.RestaurantService;
import com.archu.restaurantserviceapi.dto.RestaurantDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping(path = "/{id}")
    public RestaurantDTO getRestaurantById(@PathVariable final String id) {
        return restaurantService.findRestaurantById(id);
    }

    @PutMapping(path = "/{id}")
    public RestaurantDTO updateRestaurant(@PathVariable final String id, @RequestBody final RestaurantDTO restaurantDTO) {
        return restaurantService.updateRestaurant(id, restaurantDTO);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantDTO createRestaurant(@RequestBody final RestaurantDTO restaurantDTO) {
        return restaurantService.createRestaurant(restaurantDTO);
    }
}
