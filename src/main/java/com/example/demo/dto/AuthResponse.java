package com.example.demo.dto;

public class AuthResponse {

    private Long userId;
    private String email;
    private String token;

    public AuthResponse() {
    }

    public AuthResponse(Long userId, String email, String token) {
        this.userId = userId;
        this.email = email;
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }
}
