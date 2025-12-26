package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public String loginUser(User user) {
        // simple check, can be replaced with JWT/Auth logic later
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword())
                .map(u -> "Login successful")
                .orElse("Invalid credentials");
    }
}
