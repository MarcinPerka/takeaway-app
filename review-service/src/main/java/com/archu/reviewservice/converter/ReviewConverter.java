package com.archu.reviewservice.converter;

import com.archu.reviewservice.domain.Review;
import com.archu.reviewserviceapi.dto.ReviewDTO;
import com.archu.takeawaycommonspring.base.BaseConverter;
import org.springframework.stereotype.Component;

@Component
public class ReviewConverter implements BaseConverter<ReviewDTO, Review> {
    @Override
    public Review createFrom(final ReviewDTO dto) {
        return Review.builder()
                .author(dto.getAuthor())
                .message(dto.getMessage())
                .rating(dto.getRating())
                .build();
    }

    @Override
    public ReviewDTO createFrom(final Review entity) {
        return ReviewDTO.builder()
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
    public Review updateEntity(final Review entity, final ReviewDTO dto) {
        return entity.toBuilder()
                .version(dto.getVersion())
                .author(dto.getAuthor())
                .message(dto.getMessage())
                .rating(dto.getRating())
                .build();
    }
}
