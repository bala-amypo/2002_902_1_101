package com.example.demo.service;

import com.example.demo.dto.UserRegisterDto;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;

public interface UserService {

    AuthResponse register(UserRegisterDto dto);

    AuthResponse login(AuthRequest request);
}
