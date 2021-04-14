package com.archu.restaurantserviceapi.dto;

import com.archu.takeawaycommon.domain.menu.CuisineType;
import com.archu.takeawaycommon.domain.location.Location;
import com.archu.takeawaycommon.domain.menu.Menu;
import com.archu.takeawaycommon.domain.shipping.ShippingType;
import com.archu.takeawaycommonspring.base.domain.BaseRequest;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class RestaurantRequest extends BaseRequest {

    private Integer version;

    @NotBlank
    private String name;

    @NotEmpty
    private Set<@NotNull CuisineType> cuisineTypes;

    @NotEmpty
    private Set<@NotNull ShippingType> shippingTypes;

    @Valid
    private Menu menu;

    @Valid
    private Location location;

}
