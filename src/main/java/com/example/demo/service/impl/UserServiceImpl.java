package com.example.demo.service.impl;

import com.example.demo.dto.UserRegisterDto;
import com.example.demo.dto.AuthRequest;
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
    public User register(UserRegisterDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setRoles(dto.getRoles());
        return userRepository.save(user);
    }

    @Override
    public User login(AuthRequest request) {
        return userRepository.findByEmail(request.getEmail()).orElse(null);
    }
}
