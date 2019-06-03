package com.yyx.pwd.vo.user;

import lombok.Data;

@Data
public class LoginVo {
    private boolean isSuccess;

    private String token;
}
