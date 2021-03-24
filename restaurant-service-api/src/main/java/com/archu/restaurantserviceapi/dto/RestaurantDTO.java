package com.archu.restaurantserviceapi.dto;

import com.archu.takeawaycommon.dto.Location;
import com.archu.takeawaycommonspring.base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@Data
public class RestaurantDTO extends BaseDTO {

    private String id;

    private Integer version;

    private String name;

    private Set<Cuisine> cuisineTypes;

    private Set<Shipping> shippingTypes;

    private Menu menu;

    private Location location;

}
