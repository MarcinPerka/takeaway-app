package com.archu.restaurantservice.service;

import com.archu.restaurantserviceapi.dto.RestaurantDTO;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {

    RestaurantDTO findRestaurantById(final String id);

    List<RestaurantDTO> findAllRestaurants();

    RestaurantDTO createRestaurant(final RestaurantDTO restaurantDTO);

    RestaurantDTO updateRestaurant(final String id, final RestaurantDTO restaurantDTO);
}
