package com.example.javaeeproject.repository.impl;

import com.example.javaeeproject.db.DBManager;
import com.example.javaeeproject.model.Items;
import com.example.javaeeproject.model.Order;
import com.example.javaeeproject.model.OrderItem;
import com.example.javaeeproject.repository.OrderRepository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public boolean createOrder(int userId, String date, List<Items> items) {
        try {
            Order order = new Order();
            order.setUser_id(userId);
            order.setDate(date);

            if (DBManager.getTransaction() == null || !DBManager.getTransaction().isActive())
                DBManager.setTransaction(DBManager.getSession().beginTransaction());
            DBManager.getSession().save(order);
            DBManager.getTransaction().commit();

            DBManager.getSession().evict(order);

            List<Order> orders = getOrders(userId);
            order = orders.get(orders.size() -1);

            for (Items orderItemToAdd: items) {
                if (DBManager.getTransaction() == null || !DBManager.getTransaction().isActive())
                    DBManager.setTransaction(DBManager.getSession().beginTransaction());
                OrderItem orderItem = new OrderItem();
                orderItem.setItem_id(orderItemToAdd.getId());
                orderItem.setCount(orderItemToAdd.getAmount());
                orderItem.setOrder_id(order.getId());


                DBManager.getSession().save(orderItem);
                DBManager.getTransaction().commit();

                DBManager.getSession().evict(orderItem);
            }


        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public Order getOrder(int orderId) {
        Order order = null;
        try {
            order = DBManager.getSession().get(Order.class, orderId);

            CriteriaBuilder builder = DBManager.getSession().getCriteriaBuilder();
            CriteriaQuery<OrderItem> orderItemCriteriaQuery = builder.createQuery(OrderItem.class);
            Root<OrderItem> orderItemRoot = orderItemCriteriaQuery.from(OrderItem.class);
            orderItemCriteriaQuery.select(orderItemRoot).where(builder.equal(orderItemRoot.get("order_id"), orderId));
            order.setItems(DBManager.getSession().createQuery(orderItemCriteriaQuery).getResultList());

            for (OrderItem orderItem: order.getItems()) {
                orderItem.setItem(DBManager.getSession().get(Items.class, orderItem.getItem_id()));
            }

        } catch (Exception e) {
            return order;
        }
        return order;
    }

    @Override
    public List<Order> getOrders(int userId) {
        List<Order> orders = new ArrayList<>();
        try {
            CriteriaBuilder builder = DBManager.getSession().getCriteriaBuilder();
            CriteriaQuery<Order> criteria = builder.createQuery(Order.class);
            Root<Order> root = criteria.from(Order.class);
            criteria.select(root).where(builder.equal(root.get("user_id"), userId));
            orders = DBManager.getSession().createQuery(criteria).getResultList();
        } catch (Exception e) {
            return new ArrayList<>(orders);
        }
        return new ArrayList<>(orders);
    }
}
