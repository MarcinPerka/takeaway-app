package com.archu.restaurantserviceapi.dto;

import com.archu.takeawaycommon.domain.menu.CuisineType;
import com.archu.takeawaycommon.domain.location.Location;
import com.archu.takeawaycommon.domain.menu.Menu;
import com.archu.takeawaycommon.domain.shipping.ShippingType;
import com.archu.takeawaycommonspring.base.domain.BaseResponse;
import lombok.*;

import java.time.Instant;
import java.util.Set;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class RestaurantResponse extends BaseResponse {

    private String id;

    private Integer version;

    private String name;

    private Set<CuisineType> cuisineTypes;

    private Set<ShippingType> shippingTypes;

    private Menu menu;

    private Location location;

    private Instant createdAt;

    private Instant updatedAt;

}
