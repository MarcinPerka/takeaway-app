package com.archu.restaurantservice.converter;

import com.archu.restaurantservice.domain.Restaurant;
import com.archu.restaurantserviceapi.dto.RestaurantRequest;
import com.archu.restaurantserviceapi.dto.RestaurantResponse;
import com.archu.takeawaycommonspring.base.domain.BaseConverter;
import org.springframework.stereotype.Component;

@Component
public class RestaurantConverter implements BaseConverter<RestaurantRequest, RestaurantResponse, Restaurant> {

    @Override
    public Restaurant createFrom(final RestaurantRequest dto) {
        return Restaurant.builder()
                .name(dto.getName())
                .menu(dto.getMenu())
                .location(dto.getLocation())
                .shippingTypes(dto.getShippingTypes())
                .cuisineTypes(dto.getCuisineTypes())
                .build();
    }

    @Override
    public RestaurantResponse createFrom(final Restaurant entity) {
        return RestaurantResponse.builder()
                .id(entity.getId())
                .version(entity.getVersion())
                .name(entity.getName())
                .menu(entity.getMenu())
                .location(entity.getLocation())
                .shippingTypes(entity.getShippingTypes())
                .cuisineTypes(entity.getCuisineTypes())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    @Override
    public Restaurant updateEntity(final Restaurant entity, final RestaurantRequest dto) {
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