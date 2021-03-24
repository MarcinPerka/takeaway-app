package com.archu.restaurantservice.service;

import com.archu.restaurantservice.converter.RestaurantConverter;
import com.archu.restaurantservice.repository.RestaurantRepository;
import com.archu.restaurantserviceapi.dto.RestaurantDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    private final RestaurantConverter restaurantConverter;

    @Override
    public Optional<RestaurantDTO> findRestaurantById(final String id) {
        return restaurantRepository.findById(id).map(restaurantConverter::createFrom);
    }

    @Override
    public RestaurantDTO createRestaurant(final RestaurantDTO restaurantDTO) {
        var restaurant = restaurantConverter.createFrom(restaurantDTO);
        return restaurantConverter.createFrom(restaurantRepository.save(restaurant));
    }

    @Override
    public RestaurantDTO updateRestaurant(final String id, final RestaurantDTO restaurantDTO) {
        //TODO specified exception, exception handler and api error response.
        var restaurantToUpdate = restaurantRepository.findById(id).orElseThrow(() -> new RuntimeException(String.format("Restaurant with id %s not found", id)));
        return restaurantConverter.createFrom(restaurantRepository.save(restaurantConverter.updateEntity(restaurantToUpdate, restaurantDTO)));
    }
}
