package com.zhengl.spring.staticproxy;

public interface UserService {

    void register(User user);

    boolean login(String username, String password);
}