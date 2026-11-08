package com.huragan11.orders;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

@MicronautTest
class OrderControllerTest {

    @Inject
    @Client("/")
    HttpClient client;

    @Test
    void createOrderReturnsCreatedOrder() {
        HttpRequest<CreateOrderRequest> request = HttpRequest.POST("/orders", new CreateOrderRequest("customer-1", "product-1", 1));
        HttpResponse<Order> httpResponse = client.toBlocking().exchange(request, Order.class);

        Order order = httpResponse.body();

        Assertions.assertEquals(HttpStatus.CREATED, httpResponse.getStatus());
        Assertions.assertNotNull(order.id());
        Assertions.assertEquals("customer-1", order.customerId());
        Assertions.assertEquals("product-1", order.productId());
        Assertions.assertEquals(1, order.quantity());
    }

    @Test
    void createOrderRejectsNegativeQuantity() {
        HttpRequest<CreateOrderRequest> request = HttpRequest.POST("/orders", new CreateOrderRequest("customer-1", "product-1", -5));

        HttpClientResponseException exception = Assertions.assertThrows(HttpClientResponseException.class, () -> client.toBlocking().exchange(request, Order.class));
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());
    }


}
