package com.yyx.pwd.service;

import com.yyx.pwd.entity.ResultModel;
import com.yyx.pwd.entity.User;
import com.yyx.pwd.entity.UserSession;
import com.yyx.pwd.mapper.UserMapper;
import com.yyx.pwd.vo.user.LoginVo;
import com.yyx.pwd.vo.user.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;

import static com.yyx.pwd.enums.ResultCode.SUCCESS;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public ResultModel<LoginVo> judgeUser(String userName, String password, HttpSession session) {
        LoginVo loginVo = new LoginVo();

        User user = userMapper.findByName(userName);
        if (user == null) {
            loginVo.setSuccess(false);
            return ResultModel.valueOf(SUCCESS, loginVo, "用户不存在");
        }

        if (!user.getPassword().equals(password)) {
            loginVo.setSuccess(false);
            return ResultModel.valueOf(SUCCESS, loginVo, "密码错误");
        }

        loginVo.setSuccess(true);

        String token = DigestUtils.md5DigestAsHex(userName.getBytes());
        loginVo.setToken(token);

        session.setAttribute("user", new UserSession(userName, token));
        return ResultModel.valueOf(SUCCESS, loginVo, "验证通过");
    }

    public ResultModel<Boolean> judgeUserByToken(String userName, String token, HttpSession session) {
        UserSession userSession = (UserSession) session.getAttribute("user");
        if (userSession == null) {
            return ResultModel.valueOf(SUCCESS, false);
        }
        if (userName.equals(userSession.getUserName()) && token.equals(userSession.getToken())) {
            return ResultModel.valueOf(SUCCESS, true);
        }
        return ResultModel.valueOf(SUCCESS, false);
    }

    public ResultModel<UserInfoVo> getUserInfo(String userName) {
        User user = userMapper.findByName(userName);
        UserInfoVo userInfoVo = new UserInfoVo();
        if (user != null) {
            userInfoVo.setUserName(user.getName());
            userInfoVo.setEmail(user.getEmail());
            userInfoVo.setPhone(user.getPhone());
        }
        return ResultModel.valueOf(SUCCESS, userInfoVo);
    }

    public ResultModel<Boolean> editUser(String userName, String email, String phone) {
        User user = userMapper.findByName(userName);
        if (user == null) {
            return ResultModel.valueOf(SUCCESS, false);
        }else{
            user.setEmail(email);
            user.setPhone(phone);
            Integer result = userMapper.update(user);
            if (result > 0) {
                return ResultModel.valueOf(SUCCESS, true);
            } else {
                return ResultModel.valueOf(SUCCESS, false);
            }
        }
    }
}
