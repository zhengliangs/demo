package com.zhengl.mybatis.service.impl;

import com.zhengl.mybatis.dao.UserMapper;
import com.zhengl.mybatis.entity.User;
import com.zhengl.mybatis.service.UserService;
import org.springframework.transaction.annotation.Transactional;

// 原始类
@Transactional // 切入点
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean register(User user) {
        boolean flag = userMapper.insert(user) == 1;
        System.out.println("flag = " + flag);
        throw new RuntimeException("模拟异常，事务回滚");
    }
}
