package com.example.javaeeproject.repository.impl;

import com.example.javaeeproject.db.DBManager;
import com.example.javaeeproject.model.Items;
import com.example.javaeeproject.repository.ItemRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ItemRepositoryImpl implements ItemRepository {
    @Override
    public boolean addItem(Items item) {
        int rows = 0;
        try {
            PreparedStatement statement = DBManager.getConnection().prepareStatement("" +
                    "INSERT INTO items (id,name,price,amount) " +
                    "VALUES (NULL, ?,?,?)" +
                    "");
            statement.setString(1, item.getName());
            statement.setInt(2, item.getPrice());
            statement.setInt(3, item.getAmount());

            rows = statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            return false;
        }
        return rows > 0;
    }

    @Override
    public ArrayList<Items> getItems() {
        ArrayList<Items> items = new ArrayList<>();
        try {
            PreparedStatement statement = DBManager.getConnection().prepareStatement("" +
                    "SELECT id,name,price,amount " +
                    "FROM items ORDER BY price DESC");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                items.add(new Items(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getInt("amount")
                ));
            }
            statement.close();
        } catch (Exception e) {
            return items;
        }
        return items;
    }

    @Override
    public Items getItem(int id) {
        Items item = null;
        try {
            PreparedStatement statement = DBManager.getConnection().prepareStatement("" +
                    "SELECT id,name,price,amount " +
                    "FROM items WHERE id = ? LIMIT 1");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                item = new Items(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("price"),
                        resultSet.getInt("amount")
                );
            }
            statement.close();
        } catch (Exception e) {
            return item;
        }
        return item;
    }

    @Override
    public boolean saveItem(Items item) {
        int rows = 0;
        try {
            PreparedStatement statement = DBManager.getConnection().prepareStatement("" +
                    "UPDATE items SET name = ?, price = ?, amount = ? " +
                    "WHERE id = ? ");
            statement.setString(1, item.getName());
            statement.setInt(2, item.getPrice());
            statement.setInt(3, item.getAmount());
            statement.setInt(4, item.getId());

            rows = statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            return false;
        }
        return false;
    }

    @Override
    public boolean deleteItem(Items item) {
        int rows = 0;
        try {
            PreparedStatement statement = DBManager.getConnection().prepareStatement("" +
                    "DELETE FROM items WHERE id = ?");
            statement.setInt(1, item.getId());

            rows = statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            return false;
        }
        return rows > 0;
    }
}
