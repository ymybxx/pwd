package com.yyx.pwd.controller.user;

import com.yyx.pwd.entity.ResultModel;
import com.yyx.pwd.param.user.EditUserInfoParam;
import com.yyx.pwd.param.user.GetUserInfoParam;
import com.yyx.pwd.service.UserService;
import com.yyx.pwd.vo.user.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/get", method = RequestMethod.POST)
    public ResultModel<UserInfoVo> getUserInfo(@RequestBody GetUserInfoParam getUserInfoParam) {
        String userName = getUserInfoParam.getUserName();
        return userService.getUserInfo(userName);
    }

    @ResponseBody
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ResultModel<Boolean> editUserInfo(@RequestBody EditUserInfoParam editUserInfoParam) {
        String userName = editUserInfoParam.getUserName();
        String email = editUserInfoParam.getEmail();
        String phone = editUserInfoParam.getPhone();
        return userService.editUser(userName, email, phone);
    }
}
