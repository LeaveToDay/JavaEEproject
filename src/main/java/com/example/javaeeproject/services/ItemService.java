package com.example.javaeeproject.services;

import com.example.javaeeproject.model.Items;
import com.example.javaeeproject.repository.ItemRepository;

import java.util.ArrayList;

public class ItemService {
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public boolean addItem(Items item) {
        return itemRepository.addItem(item);
    }

    public ArrayList<Items> getItems() {
        return itemRepository.getItems();
    }

    public Items getItem(int id) {
        return itemRepository.getItem(id);
    }

    public void deleteItem(Items item) {
        itemRepository.deleteItem(item);
    }

    public boolean saveItem(Items item) {
        return itemRepository.saveItem(item);
    }
}
