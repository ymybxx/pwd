package com.yyx.pwd.entity;

import lombok.Data;

@Data
public class UserSession {
    public UserSession(String userName, String token) {
        this.userName = userName;
        this.token = token;
    }

    private String userName;
    private String token;
}
