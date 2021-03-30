package com.archu.restaurantserviceapi.dto;

import com.archu.takeawaycommon.dto.Location;
import com.archu.takeawaycommonspring.base.BaseDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Builder
@RequiredArgsConstructor
@Getter
@ToString
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

    private final Instant createdAt;

    private final Instant updatedAt;

}
