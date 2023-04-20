package com.example.javaeeproject.model;

import java.io.Serializable;

public class Items implements Serializable {
    private int id;
    private String name;
    private int price;
    private int amount;

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
