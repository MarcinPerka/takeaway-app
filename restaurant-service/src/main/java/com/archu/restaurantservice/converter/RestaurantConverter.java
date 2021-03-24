package com.archu.restaurantservice.converter;

import com.archu.restaurantservice.domain.Restaurant;
import com.archu.restaurantserviceapi.dto.RestaurantDTO;
import com.archu.takeawaycommonspring.base.BaseConverter;

public class RestaurantConverter implements BaseConverter<RestaurantDTO, Restaurant> {

    @Override
    public Restaurant createFrom(RestaurantDTO dto) {
        return Restaurant.builder()
                .name(dto.getName())
                .menu(dto.getMenu())
                .location(dto.getLocation())
                .shippingTypes(dto.getShippingTypes())
                .cuisineTypes(dto.getCuisineTypes())
                .build();
    }

    @Override
    public RestaurantDTO createFrom(Restaurant entity) {
        return RestaurantDTO.builder()
                .id(entity.getId())
                .version(entity.getVersion())
                .name(entity.getName())
                .menu(entity.getMenu())
                .location(entity.getLocation())
                .shippingTypes(entity.getShippingTypes())
                .cuisineTypes(entity.getCuisineTypes())
                .build();
    }

    @Override
    public Restaurant updateEntity(Restaurant entity, RestaurantDTO dto) {
        return entity.toBuilder()
                .version(dto.getVersion())
                .name(dto.getName())
                .menu(dto.getMenu())
                .location(dto.getLocation())
                .shippingTypes(dto.getShippingTypes())
                .cuisineTypes(dto.getCuisineTypes())
                .build();
    }
}