package com.incture.controller;

import com.incture.entities.*;
import com.incture.repository.OrderDao;
import com.incture.service.OrderService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderService orderService;

    @Mock
    private OrderDao orderDao;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddTheNewOrder() {
        OrderDTO dto = new OrderDTO();
        Order saved = new Order();
        String token = "abc123";

        when(orderService.saveOrder(dto, token)).thenReturn(saved);

        ResponseEntity<Order> response = orderController.addTheNewOrder(dto, token);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(saved, response.getBody());
    }

    @Test
    public void testGetAllOrders() {
        List<Order> orders = Arrays.asList(new Order(), new Order());

        when(orderService.getAllOrders()).thenReturn(orders);

        List<Order> result = orderController.getAllOrders();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetOrdersByOrderId() {
        int orderId = 1;
        Order order = new Order();

        when(orderService.getOrderByOrderId(orderId)).thenReturn(order);

        Order result = orderController.getOrdersByOrderId(orderId);

        assertEquals(order, result);
    }

    @Test
    public void testCancelTheOrderByOrderId() {
        int orderId = 1;
        String token = "xyz";
        Order order = new Order();

        when(orderService.cancelOrderByOrderId(orderId, token)).thenReturn(order);

        Order result = orderController.cancelTheOrderByOrderId(orderId, token);

        assertEquals(order, result);
    }

    @Test
    public void testUpdateOrderByOrder() {
        int orderId = 5;
        String token = "123token";
        OrderDTO dto = new OrderDTO();
        Order updated = new Order();

        when(orderService.updateOrderByOrder(dto, orderId, token)).thenReturn(updated);

        ResponseEntity<Order> response = orderController.updateOrderByOrder(dto, orderId, token);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals(updated, response.getBody());
    }

    @Test
    public void testGetOrdersByDate() {
        String date = "01-04-2025";
        LocalDate parsedDate = LocalDate.of(2025, 4, 1);
        List<Order> orders = List.of(new Order());

        when(orderService.getAllOrdersByDate(parsedDate)).thenReturn(orders);

        List<Order> result = orderController.getOrdersByDate(date);

        assertEquals(1, result.size());
    }

    @Test
    public void testGetCustomerDetailsByOrderId() {
        int orderId = 100;
        Customer customer = new Customer();

        when(orderService.getCustomerByOrderid(orderId)).thenReturn(customer);

        Customer result = orderController.getCustomerDetailsByOrderId(orderId);

        assertEquals(customer, result);
    }
}
