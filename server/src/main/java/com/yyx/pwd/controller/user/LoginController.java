package com.yyx.pwd.controller.user;

import com.yyx.pwd.entity.ResultModel;
import com.yyx.pwd.param.user.LoginParam;
import com.yyx.pwd.param.user.TokenParam;
import com.yyx.pwd.service.UserService;
import com.yyx.pwd.vo.user.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultModel<LoginVo> login(@RequestBody LoginParam loginParam, HttpSession session) {

        String userName = loginParam.getUserName();
        String password = loginParam.getPassword();

        return userService.judgeUser(userName, password, session);
    }

    @ResponseBody
    @RequestMapping(value = "/isLogin", method = RequestMethod.POST)
    public ResultModel<Boolean> isLogin(@RequestBody TokenParam tokenParam, HttpSession session) {
        return userService.judgeUserByToken(tokenParam.getUserName(), tokenParam.getToken(), session);
    }

}
