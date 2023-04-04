package com.zhengl.spring;

import com.zhengl.spring.staticproxy.User;
import com.zhengl.spring.staticproxy.UserService;
import com.zhengl.spring.staticproxy.UserServiceProxy;
import org.junit.Test;

public class StaticProxyTest {

    @Test
    public void test1(){
        UserService userService = new UserServiceProxy();
        userService.register(new User());
        userService.login("username", "password");
    }

}
