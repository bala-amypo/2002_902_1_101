package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;   // 🔥 REQUIRED by UserServiceImpl

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String roles;
}
