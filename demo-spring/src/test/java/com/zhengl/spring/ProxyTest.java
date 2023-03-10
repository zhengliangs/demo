package com.zhengl.spring;

import com.zhengl.spring.proxy.User;
import com.zhengl.spring.proxy.UserService;
import com.zhengl.spring.proxy.UserServiceProxy;
import org.junit.Test;

public class ProxyTest {

    @Test
    public void test1(){
        UserService userService = new UserServiceProxy();
        userService.register(new User());
        userService.login("username", "password");
    }

}
