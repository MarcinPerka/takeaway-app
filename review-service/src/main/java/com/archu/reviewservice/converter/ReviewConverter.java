package com.archu.reviewservice.converter;

import com.archu.reviewservice.domain.Review;
import com.archu.reviewserviceapi.dto.ReviewRequest;
import com.archu.reviewserviceapi.dto.ReviewResponse;
import com.archu.takeawaycommonspring.base.domain.BaseConverter;
import org.springframework.stereotype.Component;

@Component
public class ReviewConverter implements BaseConverter<ReviewRequest, ReviewResponse, Review> {
    @Override
    public Review createFrom(final ReviewRequest dto) {
        return Review.builder()
                .author(dto.getAuthor())
                .message(dto.getMessage())
                .rating(dto.getRating())
                .build();
    }

    @Override
    public ReviewResponse createFrom(final Review entity) {
        return ReviewResponse.builder()
                .id(entity.getId())
                .version(entity.getVersion())
                .author(entity.getAuthor())
                .message(entity.getMessage())
                .rating(entity.getRating())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }

    @Override
    public Review updateEntity(final Review entity, final ReviewRequest dto) {
        return entity.toBuilder()
                .version(dto.getVersion())
                .author(dto.getAuthor())
                .message(dto.getMessage())
                .rating(dto.getRating())
                .build();
    }
}
