package com.zhengl.spring.proxy;

public interface UserService {

    void register(User user);

    boolean login(String username, String password);
}
