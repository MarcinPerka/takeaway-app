package com.archu.takeawaycommon.domain.payment;

import lombok.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@ToString
public class PaymentDetails {

    private PaymentType type;

}
