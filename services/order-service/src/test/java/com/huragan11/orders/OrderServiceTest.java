package com.huragan11.orders;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    private final OrderService orderService = new OrderService();

    @Test
    void createOrderReturnsOrderAndCanFindIt() {
        Order order = orderService.create(new CreateOrderRequest("cust-1", "prod-1", 2));
        Assertions.assertNotNull(order.id());
        Assertions.assertNotNull(orderService.findById(order.id()));
    }

}
