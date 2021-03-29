package com.archu.restaurantservice.controller;

import com.archu.restaurantservice.service.RestaurantService;
import com.archu.restaurantserviceapi.dto.RestaurantDTO;
import com.archu.takeawaycommonspring.apiversion.MediaType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(produces = MediaType.APPLICATION_TAKEAWAY_V1_JSON_VALUE, consumes = MediaType.APPLICATION_TAKEAWAY_V1_JSON_VALUE)
public class RestaurantController {

    private final RestaurantService restaurantService;

    @GetMapping("{id}")
    public RestaurantDTO getRestaurantById(@PathVariable final String id) {
        return restaurantService.findRestaurantById(id);
    }

    @GetMapping
    public List<RestaurantDTO> getAllRestaurants() {
        return restaurantService.findAllRestaurants();
    }

    @PutMapping("{id}")
    public RestaurantDTO updateRestaurant(@PathVariable final String id, @Valid @RequestBody final RestaurantDTO restaurantDTO) {
        return restaurantService.updateRestaurant(id, restaurantDTO);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantDTO createRestaurant(@Valid @RequestBody final RestaurantDTO restaurantDTO) {
        return restaurantService.createRestaurant(restaurantDTO);
    }
}
