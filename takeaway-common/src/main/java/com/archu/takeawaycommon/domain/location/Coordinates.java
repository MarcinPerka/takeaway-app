package com.archu.takeawaycommon.domain.location;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class Coordinates {

    @NotNull
    @Min(-90)
    @Max(90)
    private BigDecimal latitude;

    @NotNull
    @Min(-180)
    @Max(180)
    private BigDecimal longitude;
}
