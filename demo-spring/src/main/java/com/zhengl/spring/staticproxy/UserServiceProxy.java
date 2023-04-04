package com.zhengl.spring.staticproxy;

public class UserServiceProxy implements UserService {

    private UserService userService = new UserServiceImpl();

    @Override
    public void register(User user) {
        System.out.println("-------log------");
        userService.register(user);
    }

    @Override
    public boolean login(String username, String password) {
        System.out.println("-------log------");
        userService.login(username, password);
        return false;
    }
}
