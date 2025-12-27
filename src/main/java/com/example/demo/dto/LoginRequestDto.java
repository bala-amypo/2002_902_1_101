package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LoginRequest {

    @Schema(example = "admin@gmail.com")
    private String email;

    @Schema(example = "password123")
    private String password;
}
