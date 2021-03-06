package com.archu.restaurantservice.service;

import com.archu.restaurantservice.converter.RestaurantConverter;
import com.archu.restaurantservice.domain.Restaurant;
import com.archu.restaurantservice.repository.RestaurantRepository;
import com.archu.restaurantserviceapi.model.RestaurantRequest;
import com.archu.restaurantserviceapi.model.RestaurantResponse;
import com.archu.takeawaycommonspring.base.page.PagingAndSortingRequest;
import com.archu.takeawaycommonspring.exception.types.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    private final RestaurantConverter restaurantConverter;

    @Override
    public Optional<RestaurantResponse> findRestaurantById(final String id) {
        return restaurantRepository.findById(id).map(restaurantConverter::createFrom);
    }

    @Override
    public Page<RestaurantResponse> findRestaurants(final int page, final int size, final List<String> sort) {
        final var pageRequest = PagingAndSortingRequest.of(page, size, sort);
        return restaurantRepository.findAll(pageRequest).map(restaurantConverter::createFrom);
    }

    @Override
    public RestaurantResponse createRestaurant(final RestaurantRequest restaurantRequest) {
        final var restaurant = restaurantConverter.createFrom(restaurantRequest);
        return restaurantConverter.createFrom(restaurantRepository.save(restaurant));
    }

    @Override
    public RestaurantResponse updateRestaurant(final String id, final RestaurantRequest restaurantRequest) {
        final var restaurantToUpdate = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Restaurant.class, "id", id));
        return restaurantConverter.createFrom(restaurantRepository.save(restaurantConverter.updateEntity(restaurantToUpdate, restaurantRequest)));
    }
}
