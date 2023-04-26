package com.zhengl.spring.factory;

import com.zhengl.spring.staticproxy.User;

public class UserServiceImpl implements UserService{
    @Override
    public void login(String username, String password) {
        System.out.println("UserServiceImpl.login");
    }

    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register");
    }
}
