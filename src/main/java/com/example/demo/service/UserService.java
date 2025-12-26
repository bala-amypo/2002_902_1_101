package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.UserRegisterDto;

public interface UserService {
    AuthResponse register(UserRegisterDto dto);
    AuthResponse login(AuthRequest request);
}
