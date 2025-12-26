package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service  // Marks this as a Spring service bean
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> login(String username, String password) {
        // Must match the interface signature exactly
        return userRepository.findByUsernameAndPassword(username, password);
    }

    // Other methods from UserService interface must be implemented here
}
