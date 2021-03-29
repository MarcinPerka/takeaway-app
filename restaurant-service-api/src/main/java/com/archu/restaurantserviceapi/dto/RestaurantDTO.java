package com.archu.restaurantserviceapi.dto;

import com.archu.takeawaycommon.dto.Location;
import com.archu.takeawaycommonspring.base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@Data
public class RestaurantDTO extends BaseDTO {

    private final String id;

    private final Integer version;

    @NotBlank
    private final String name;

    @NotEmpty
    private final Set<@NotNull Cuisine> cuisineTypes;

    @NotEmpty
    private final Set<@NotNull Shipping> shippingTypes;

    @Valid
    private final Menu menu;

    @Valid
    private final Location location;

}
