package com.zhengl.spring.aspect;

import com.zhengl.spring.staticproxy.User;

public interface UserService {

    void register(User user);

    boolean login(String username, String password);
}