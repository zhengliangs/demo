package com.zhengl.mybatis.service;

import com.zhengl.mybatis.entity.User;

public interface UserService {

    boolean register(User user);

    boolean login(String name, String password);
}
