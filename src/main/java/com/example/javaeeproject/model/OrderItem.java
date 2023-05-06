package com.example.javaeeproject.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_item")
public class OrderItem {
    @Id @Column(name = "id") private int id;
    @Column(name = "order_id") private int order_id;
    @Column(name = "item_id") private int item_id;
    @Column(name = "count") private int count;
    @Transient private Items item;

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Items getItem() {
        return item;
    }

    public void setItem(Items item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderItem)) return false;
        OrderItem orderItem = (OrderItem) o;
        return getId() == orderItem.getId() && getOrder_id() == orderItem.getOrder_id() && getItem_id() == orderItem.getItem_id() && getCount() == orderItem.getCount() && Objects.equals(getItem(), orderItem.getItem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOrder_id(), getItem_id(), getCount(), getItem());
    }

    public OrderItem() {
    }
}
