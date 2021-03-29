package com.archu.takeawaycommon.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class Money {

    public static Money ZERO = Money.of(0);

    @Positive
    @NotNull
    private final BigDecimal amount;

    public static Money of(final BigDecimal amount) {
        return new Money(amount);
    }

    public static Money of(final String amount) {
        return new Money(new BigDecimal(amount));
    }

    public static Money of(final int amount) {
        return new Money(new BigDecimal(amount));
    }

    public Money add(final Money delta) {
        return new Money(amount.add(delta.amount));
    }

    public boolean isGreaterThanOrEqual(final Money other) {
        return amount.compareTo(other.amount) >= 0;
    }

    public Money multiply(final int x) {
        return new Money(amount.multiply(new BigDecimal(x)));
    }

}