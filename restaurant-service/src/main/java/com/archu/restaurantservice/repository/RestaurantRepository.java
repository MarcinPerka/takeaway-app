package com.archu.restaurantservice.repository;

import com.archu.restaurantservice.domain.QRestaurant;
import com.archu.restaurantservice.domain.Restaurant;
import com.archu.takeawaycommonspring.base.filter.MyQuerydslBinderCustomizer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String>, MyQuerydslBinderCustomizer<QRestaurant>, QuerydslPredicateExecutor<Restaurant> {

    @Override
    default void customize(final QuerydslBindings bindings, final QRestaurant root) {
        bindings.excluding(root.id, root.version);
        MyQuerydslBinderCustomizer.super.customize(bindings, root);
    }
}
