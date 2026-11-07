package com.huragan11.orders;

import jakarta.inject.Singleton;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class OrderService {

    // In-memory storage until PostgreSQL is added in step 3
    private final Map<UUID, Order> orders = new ConcurrentHashMap<>();

    public Order create(CreateOrderRequest request) {
        Order order = new Order(UUID.randomUUID(), request.customerId(), request.productId(), request.quantity());
        orders.put(order.id(), order);
        return order;
    }

    public Optional<Order> findById(UUID id) {
        return Optional.ofNullable(orders.get(id));
    }
}
