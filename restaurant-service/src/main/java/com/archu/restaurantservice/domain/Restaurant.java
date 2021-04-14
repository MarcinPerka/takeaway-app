package com.archu.restaurantservice.domain;

import com.archu.takeawaycommon.domain.menu.CuisineType;
import com.archu.takeawaycommon.domain.menu.Menu;
import com.archu.takeawaycommon.domain.shipping.ShippingType;
import com.archu.takeawaycommon.domain.location.Location;
import com.archu.takeawaycommonspring.base.domain.BaseEntity;
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

    private Set<CuisineType> cuisineTypes;

    private Set<ShippingType> shippingTypes;

    private Menu menu;

    private Location location;

}
