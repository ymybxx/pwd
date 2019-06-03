package com.yyx.pwd.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    private String name;

    private Long id;

    private String password;

    private String email;

    private String phone;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
