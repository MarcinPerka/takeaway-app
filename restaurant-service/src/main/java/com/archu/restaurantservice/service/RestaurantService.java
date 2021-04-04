package com.archu.restaurantservice.service;

import com.archu.restaurantserviceapi.dto.RestaurantRequest;
import com.archu.restaurantserviceapi.dto.RestaurantResponse;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RestaurantService {

    RestaurantResponse findRestaurantById(final String id);

    Page<RestaurantResponse> findRestaurants(final int page, final int size, final List<String> sort, final Predicate predicate);

    RestaurantResponse createRestaurant(final RestaurantRequest restaurantRequest);

    RestaurantResponse updateRestaurant(final String id, final RestaurantRequest restaurantRequest);
}
