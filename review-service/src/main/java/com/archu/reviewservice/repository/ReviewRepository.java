package com.archu.reviewservice.repository;

import com.archu.reviewservice.domain.QReview;
import com.archu.reviewservice.domain.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String>, QuerydslPredicateExecutor<Review>, QuerydslBinderCustomizer<QReview> {

    @Override
    default void customize(final QuerydslBindings bindings, final QReview root) {
        bindings.excluding(root.id, root.version);
    }
}
