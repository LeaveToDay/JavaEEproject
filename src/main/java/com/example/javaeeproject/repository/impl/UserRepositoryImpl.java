package com.example.javaeeproject.repository.impl;

import com.example.javaeeproject.db.DBManager;
import com.example.javaeeproject.model.Users;
import com.example.javaeeproject.repository.UserRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public boolean addUser(Users user) {
        int rows = 0;
        try {
            PreparedStatement statement = DBManager.getConnection().prepareStatement("" +
                    "INSERT INTO users (id,email,password,full_name) " +
                    "VALUES (NULL, ?,?,?)" +
                    "");
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFull_name());

            rows = statement.executeUpdate();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rows > 0;
    }

    @Override
    public Users getUser(String email) {
        Users user = null;
        try {
            PreparedStatement statement = DBManager.getConnection().prepareStatement("SELECT * FROM users WHERE email = ?");
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                user = new Users(
                        resultSet.getInt("id"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("full_name")
                );
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
