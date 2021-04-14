package com.archu.restaurantserviceapi.dto;

import com.archu.takeawaycommon.dto.Cuisine;
import com.archu.takeawaycommon.dto.Location;
import com.archu.takeawaycommon.dto.Menu;
import com.archu.takeawaycommon.dto.Shipping;
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

    private Set<Cuisine> cuisineTypes;

    private Set<Shipping> shippingTypes;

    private Menu menu;

    private Location location;

    private Instant createdAt;

    private Instant updatedAt;

}
