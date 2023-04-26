package com.zhengl.spring.aspect;

import com.zhengl.spring.staticproxy.User;

public class UserServiceImpl implements UserService {

    @Override
    public void register(User user) {
        System.out.println("UserServiceImpl.register");
    }

    @Override
    public boolean login(String username, String password) {
        System.out.println("UserServiceImpl.login");
        return false;
    }
}
