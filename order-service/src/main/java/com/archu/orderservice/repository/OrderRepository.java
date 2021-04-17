package com.archu.orderservice.repository;

import com.archu.orderservice.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String>, QuerydslPredicateExecutor<Order> {
}
