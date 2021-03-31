package com.archu.restaurantservice.service;

import com.archu.restaurantservice.converter.RestaurantConverter;
import com.archu.restaurantservice.repository.RestaurantRepository;
import com.archu.restaurantserviceapi.dto.RestaurantDTO;
import com.archu.takeawaycommonspring.base.page.PagingAndSortingRequest;
import com.archu.takeawaycommonspring.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    private final RestaurantConverter restaurantConverter;

    @Override
    public RestaurantDTO findRestaurantById(final String id) {
        return restaurantRepository.findById(id).map(restaurantConverter::createFrom)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Restaurant with id %s not found", id)));
    }

    @Override
    public Page<RestaurantDTO> findRestaurants(final int page, final int size, final List<String> sort) {
        final var pageRequest = PagingAndSortingRequest.of(page, size, sort);
        return restaurantRepository.findAll(pageRequest).map(restaurantConverter::createFrom);
    }

    @Override
    public RestaurantDTO createRestaurant(final RestaurantDTO restaurantDTO) {
        var restaurant = restaurantConverter.createFrom(restaurantDTO);
        return restaurantConverter.createFrom(restaurantRepository.save(restaurant));
    }

    @Override
    public RestaurantDTO updateRestaurant(final String id, final RestaurantDTO restaurantDTO) {
        var restaurantToUpdate = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Restaurant with id %s not found", id)));
        return restaurantConverter.createFrom(restaurantRepository.save(restaurantConverter.updateEntity(restaurantToUpdate, restaurantDTO)));
    }
}
