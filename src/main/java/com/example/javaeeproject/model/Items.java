package com.example.javaeeproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "items")
public class Items implements Serializable {

    @Id @Column(name = "id") private int id;
    @Column(name = "name") private String name;
    @Column(name = "price") private int price;
    @Column(name = "amount") private int amount;

    public Items() {
    }

    public Items(int id, String name, int price, int amount) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public Items copy() {
        return new Items(
                id, name, price,1
        );
    }
}
