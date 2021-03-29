package com.archu.takeawaycommon.dto;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class Coordinates {

    public final Coordinates ZERO = Coordinates.of(0, 0);

    @NotNull
    @Min(-90)
    @Max(90)
    private final BigDecimal latitude;

    @NotNull
    @Min(-180)
    @Max(180)
    private final BigDecimal longitude;

    public static Coordinates of(final BigDecimal latitude, final BigDecimal longitude) {
        return new Coordinates(latitude, longitude);
    }

    public static Coordinates of(final String latitude, final String longitude) {
        return new Coordinates(new BigDecimal(latitude), new BigDecimal(longitude));
    }

    public static Coordinates of(final int latitude, final int longitude) {
        return new Coordinates(new BigDecimal(latitude), new BigDecimal(longitude));
    }
}
