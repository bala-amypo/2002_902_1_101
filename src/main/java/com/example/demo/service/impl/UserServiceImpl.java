package com.example.demo.service.impl;

import com.example.demo.dto.UserRegisterDto;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public AuthResponse register(UserRegisterDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        // if roles in User model is String, join Set<String> to comma
        user.setRoles(String.join(",", dto.getRoles()));
        userRepository.save(user);
        return new AuthResponse(user.getUsername(), user.getEmail());
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        // Simple login without password check
        return new AuthResponse(user.getUsername(), user.getEmail());
    }
}
