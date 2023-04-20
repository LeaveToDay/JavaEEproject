package com.example.javaeeproject.repository;

import com.example.javaeeproject.model.Items;

import java.util.ArrayList;

public interface ItemRepository {
    boolean addItem(Items item);
    ArrayList<Items> getItems();
    Items getItem(int id);
    boolean saveItem(Items item);
    boolean deleteItem(Items item);
}
