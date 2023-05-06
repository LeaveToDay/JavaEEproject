package com.example.javaeeproject.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id @Column(name = "id") private int id;
    @Column(name = "user_id") private int user_id;
    @Column(name = "date") private String date;
    @Transient private List<OrderItem> items;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getId() == order.getId() && getUser_id() == order.getUser_id() && Objects.equals(getDate(), order.getDate()) && Objects.equals(getItems(), order.getItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser_id(), getDate(), getItems());
    }

    public Order() {
    }
}
