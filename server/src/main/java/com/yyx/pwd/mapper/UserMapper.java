package com.yyx.pwd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyx.pwd.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    User findByName(String name);
    //更新用户
    Integer update(User User);
}
