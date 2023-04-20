package com.example.javaeeproject.repository;

import com.example.javaeeproject.model.Users;

public interface UserRepository {
    boolean addUser(Users user);

    Users getUser(String email);
}
