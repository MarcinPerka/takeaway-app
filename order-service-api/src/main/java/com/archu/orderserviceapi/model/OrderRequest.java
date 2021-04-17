package com.archu.orderserviceapi.model;

import com.archu.takeawaycommon.domain.payment.PaymentDetails;
import com.archu.takeawaycommon.domain.shipping.ShippingDetails;
import com.archu.takeawaycommonspring.base.domain.BaseRequest;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class OrderRequest extends BaseRequest {

    private Integer version;

    private OrderState state;

    @NotBlank
    private String restaurantId;

    @NotBlank
    private String customerId;

    @Valid
    @NotNull
    private OrderLineItems orderLineItems;

    @Valid
    @NotNull
    private PaymentDetails paymentDetails;

    @Valid
    @NotNull
    private ShippingDetails shippingDetails;

}
