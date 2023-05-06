package com.example.javaeeproject.repository;

import com.example.javaeeproject.model.Items;
import com.example.javaeeproject.model.Order;

import java.util.List;

public interface OrderRepository {
    public boolean createOrder(int userId, String date, List<Items> items);
    public Order getOrder(int orderId);
    public List<Order> getOrders(int userId);
}
