package com.archu.restaurantservice.service;

import com.archu.restaurantservice.domain.Restaurant;
import com.archu.restaurantservice.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public Optional<Restaurant> findRestaurantById(final String id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public Restaurant createRestaurant(final Restaurant restaurant) {
        return null;
    }

    @Override
    public void updateRestaurant(final String id, final Restaurant restaurant) {

    }
}
