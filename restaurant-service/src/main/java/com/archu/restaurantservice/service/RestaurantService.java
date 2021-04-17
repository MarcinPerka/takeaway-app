package com.archu.restaurantservice.service;

import com.archu.restaurantserviceapi.model.RestaurantRequest;
import com.archu.restaurantserviceapi.model.RestaurantResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RestaurantService {

    RestaurantResponse findRestaurantById(final String id);

    Page<RestaurantResponse> findRestaurants(final int page, final int size, final List<String> sort);

    RestaurantResponse createRestaurant(final RestaurantRequest restaurantRequest);

    RestaurantResponse updateRestaurant(final String id, final RestaurantRequest restaurantRequest);
}
