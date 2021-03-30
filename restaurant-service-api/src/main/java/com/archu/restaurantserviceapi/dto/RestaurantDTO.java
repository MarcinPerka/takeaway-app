package com.archu.restaurantserviceapi.dto;

import com.archu.takeawaycommon.dto.Location;
import com.archu.takeawaycommonspring.base.BaseDTO;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.Set;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class RestaurantDTO extends BaseDTO {

    private String id;

    private Integer version;

    @NotBlank
    private String name;

    @NotEmpty
    private Set<@NotNull Cuisine> cuisineTypes;

    @NotEmpty
    private Set<@NotNull Shipping> shippingTypes;

    @Valid
    private Menu menu;

    @Valid
    private Location location;

    private Instant createdAt;

    private Instant updatedAt;

}
