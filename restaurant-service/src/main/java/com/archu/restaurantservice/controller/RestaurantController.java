package com.archu.restaurantservice.controller;

import com.archu.restaurantservice.domain.Restaurant;
import com.archu.restaurantservice.repository.RestaurantRepository;
import com.archu.restaurantservice.service.RestaurantService;
import com.archu.restaurantserviceapi.dto.RestaurantRequest;
import com.archu.restaurantserviceapi.dto.RestaurantResponse;
import com.archu.takeawaycommonspring.apiversion.MediaType;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
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

    @GetMapping("/{id}")
    public RestaurantResponse getRestaurantById(@PathVariable final String id) {
        return restaurantService.findRestaurantById(id);
    }

    @GetMapping
    public Page<RestaurantResponse> getRestaurants(@RequestParam(defaultValue = "0") final int page,
                                                   @RequestParam(defaultValue = "10") final int size,
                                                   @RequestParam(defaultValue = "") final List<String> sort,
                                                   @QuerydslPredicate(root = Restaurant.class, bindings = RestaurantRepository.class) final Predicate predicate) {
        return restaurantService.findRestaurants(page, size, sort, predicate);
    }

    @PutMapping("/{id}")
    public RestaurantResponse updateRestaurant(@PathVariable final String id, @Valid @RequestBody final RestaurantRequest restaurantRequest) {
        return restaurantService.updateRestaurant(id, restaurantRequest);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantResponse createRestaurant(@Valid @RequestBody final RestaurantRequest restaurantRequest) {
        return restaurantService.createRestaurant(restaurantRequest);
    }
}
