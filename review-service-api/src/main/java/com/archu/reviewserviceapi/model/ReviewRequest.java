package com.archu.reviewserviceapi.model;

import com.archu.takeawaycommonspring.base.domain.BaseRequest;
import lombok.*;

import javax.validation.constraints.*;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE, staticName = "of")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class ReviewRequest extends BaseRequest {

    private Integer version;

    @NotBlank
    @Size(min = 3, max = 40)
    private String author;

    @NotBlank
    @Size(min = 3, max = 255)
    private String message;

    @NotNull
    @Min(1)
    @Max(5)
    private int foodRating;

    @NotNull
    @Min(1)
    @Max(5)
    private int deliveryRating;

    @NotBlank
    private String restaurantId;
}