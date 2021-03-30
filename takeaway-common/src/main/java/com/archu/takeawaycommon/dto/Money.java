package com.archu.takeawaycommon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Money {

    @Positive
    @NotNull
    private BigDecimal amount;

}