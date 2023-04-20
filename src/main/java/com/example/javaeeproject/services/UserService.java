package com.example.javaeeproject.services;

import com.example.javaeeproject.model.Users;
import com.example.javaeeproject.repository.UserRepository;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean addUser(Users user) {
        return userRepository.addUser(user);
    }

    public Users getUser(String email) {
        return userRepository.getUser(email);
    }
}
