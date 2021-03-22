package com.archu.commondtos;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode
@ToString
public class Money {

    public static Money ZERO = Money.of(0);

    @NonNull
    private final BigDecimal amount;

    public static Money of(BigDecimal amount) {
        return new Money(amount);
    }

    public static Money of(String amount) {
        return new Money(new BigDecimal(amount));
    }

    public static Money of(int amount) {
        return new Money(new BigDecimal(amount));
    }

    public Money add(Money delta) {
        return new Money(amount.add(delta.amount));
    }

    public boolean isGreaterThanOrEqual(Money other) {
        return amount.compareTo(other.amount) >= 0;
    }

    public Money multiply(int x) {
        return new Money(amount.multiply(new BigDecimal(x)));
    }

}