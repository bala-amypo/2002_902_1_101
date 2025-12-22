package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.UserRegisterDto;
import com.example.demo.model.User;

public interface UserService {

    // ✅ Registration returns AuthResponse
    AuthResponse register(UserRegisterDto dto);

    // ✅ Login returns AuthResponse
    AuthResponse login(AuthRequest request);

    // ✅ Required method (was missing in impl)
    User getByEmail(String email);
}
