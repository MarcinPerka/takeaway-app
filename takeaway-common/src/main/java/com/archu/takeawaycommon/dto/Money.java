package com.archu.takeawaycommon.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@EqualsAndHashCode
@ToString
public class Money {

    @Positive
    @NotNull
    private final BigDecimal amount;

}