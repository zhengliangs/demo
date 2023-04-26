package com.zhengl.spring.factory;

import com.zhengl.spring.staticproxy.User;

public interface UserService {

    void login(String username, String password);

    void register(User user);
}
