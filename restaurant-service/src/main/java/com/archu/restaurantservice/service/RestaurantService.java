package com.archu.restaurantservice.service;

import com.archu.restaurantserviceapi.dto.RestaurantDTO;

import java.util.Optional;

public interface RestaurantService {

    Optional<RestaurantDTO> findRestaurantById(final String id);

    RestaurantDTO createRestaurant(final RestaurantDTO restaurantDTO);

    RestaurantDTO updateRestaurant(final String id, final RestaurantDTO restaurantDTO);
}
