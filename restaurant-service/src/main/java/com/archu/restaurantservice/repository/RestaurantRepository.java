package com.archu.restaurantservice.repository;

import com.archu.restaurantservice.domain.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String>, QuerydslPredicateExecutor<Restaurant> {

}
