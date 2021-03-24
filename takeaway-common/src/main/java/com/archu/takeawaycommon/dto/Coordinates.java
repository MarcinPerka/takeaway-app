package com.archu.takeawaycommon.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class Coordinates {

    public final Coordinates ZERO = Coordinates.of(0, 0);

    @NonNull
    private final BigDecimal latitude;

    @NonNull
    private final BigDecimal longitude;

    public static Coordinates of(BigDecimal latitude, BigDecimal longitude) {
        return new Coordinates(latitude, longitude);
    }

    public static Coordinates of(String latitude, String longitude) {
        return new Coordinates(new BigDecimal(latitude), new BigDecimal(longitude));
    }

    public static Coordinates of(int latitude, int longitude) {
        return new Coordinates(new BigDecimal(latitude), new BigDecimal(longitude));
    }
}
