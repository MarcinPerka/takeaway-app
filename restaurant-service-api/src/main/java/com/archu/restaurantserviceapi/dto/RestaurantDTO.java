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
import java.util.HashSet;
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
    @Builder.Default
    private final Set<@NotNull Cuisine> cuisineTypes = new HashSet<>();

    @NotEmpty
    @Builder.Default
    private final Set<@NotNull Shipping> shippingTypes = new HashSet<>();

    @Valid
    private final Menu menu;

    @Valid
    private final Location location;

}
