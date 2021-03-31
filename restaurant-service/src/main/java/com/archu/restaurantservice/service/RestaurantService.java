package com.archu.restaurantservice.service;

import com.archu.restaurantserviceapi.dto.RestaurantDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {

    RestaurantDTO findRestaurantById(final String id);

    Page<RestaurantDTO> findRestaurants(final int page, final int size, final List<String> sort);

    RestaurantDTO createRestaurant(final RestaurantDTO restaurantDTO);

    RestaurantDTO updateRestaurant(final String id, final RestaurantDTO restaurantDTO);
}
