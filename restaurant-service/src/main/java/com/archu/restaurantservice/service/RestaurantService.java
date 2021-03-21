package com.archu.restaurantservice.service;

import com.archu.restaurantservice.domain.Restaurant;

import java.util.Optional;

public interface RestaurantService {

    Optional<Restaurant> findRestaurantById(final String id);

    Restaurant createRestaurant(final Restaurant restaurant);

    void updateRestaurant(final String id, final Restaurant restaurant);
}
