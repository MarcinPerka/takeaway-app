package com.archu.takeawaycommon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
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
