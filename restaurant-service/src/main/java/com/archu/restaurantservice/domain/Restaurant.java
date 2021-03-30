package com.archu.restaurantservice.domain;

import com.archu.restaurantserviceapi.dto.Cuisine;
import com.archu.restaurantserviceapi.dto.Menu;
import com.archu.restaurantserviceapi.dto.Shipping;
import com.archu.takeawaycommon.dto.Location;
import com.archu.takeawaycommonspring.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Document(collection = "restaurants")
@Getter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@ToString
public class Restaurant extends BaseEntity {

    private String name;

    private Set<Cuisine> cuisineTypes;

    private Set<Shipping> shippingTypes;

    private Menu menu;

    private Location location;

}
