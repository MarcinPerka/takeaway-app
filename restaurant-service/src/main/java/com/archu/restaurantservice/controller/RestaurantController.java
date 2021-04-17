package com.archu.restaurantservice.controller;

import com.archu.restaurantservice.service.RestaurantService;
import com.archu.restaurantserviceapi.model.RestaurantRequest;
import com.archu.restaurantserviceapi.model.RestaurantResponse;
import com.archu.takeawaycommonspring.apiversion.MediaType;
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
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_TAKEAWAY_V1_JSON_VALUE)
    public RestaurantResponse getRestaurantById(@PathVariable final String id) {
        return restaurantService.findRestaurantById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_TAKEAWAY_V1_JSON_VALUE)
    public Page<RestaurantResponse> getRestaurants(@RequestParam(defaultValue = "0") final int page,
                                                   @RequestParam(defaultValue = "10") final int size,
                                                   @RequestParam(defaultValue = "") final List<String> sort) {
        return restaurantService.findRestaurants(page, size, sort);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_TAKEAWAY_V1_JSON_VALUE, consumes = MediaType.APPLICATION_TAKEAWAY_V1_JSON_VALUE)
    public RestaurantResponse updateRestaurant(@PathVariable final String id, @Valid @RequestBody final RestaurantRequest restaurantRequest) {
        return restaurantService.updateRestaurant(id, restaurantRequest);
    }

    @PostMapping(produces = MediaType.APPLICATION_TAKEAWAY_V1_JSON_VALUE, consumes = MediaType.APPLICATION_TAKEAWAY_V1_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantResponse createRestaurant(@Valid @RequestBody final RestaurantRequest restaurantRequest) {
        return restaurantService.createRestaurant(restaurantRequest);
    }
}
