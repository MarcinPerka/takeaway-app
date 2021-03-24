package com.archu.restaurantservice.domain;

import com.archu.restaurantserviceapi.dto.Cuisine;
import com.archu.restaurantserviceapi.dto.Menu;
import com.archu.restaurantserviceapi.dto.Shipping;
import com.archu.takeawaycommon.dto.Location;
import com.archu.takeawaycommonspring.base.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "restaurants")
@Getter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@EqualsAndHashCode(callSuper = true)
@ToString
public class Restaurant extends BaseEntity {

    private final String name;

    private final Set<Cuisine> cuisineTypes;

    private final Set<Shipping> shippingTypes;

    private final Menu menu;

    private final Location location;

}
