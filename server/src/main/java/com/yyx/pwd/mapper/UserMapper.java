package com.yyx.pwd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yyx.pwd.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    List<User> findByIds(@Param("ids")List<Long> userIds);
}
