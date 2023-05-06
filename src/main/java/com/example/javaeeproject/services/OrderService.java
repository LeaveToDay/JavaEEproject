package com.example.javaeeproject.services;

import com.example.javaeeproject.model.Items;
import com.example.javaeeproject.model.Order;
import com.example.javaeeproject.repository.OrderRepository;
import java.util.List;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public boolean createOrder(int userId, String date, List<Items> items) {
        return orderRepository.createOrder(userId, date, items);
    }

    public Order getOrder(int orderId) {
        return orderRepository.getOrder(orderId);
    }

    public List<Order> getOrders(int userId) {
        return orderRepository.getOrders(userId);
    }
}
