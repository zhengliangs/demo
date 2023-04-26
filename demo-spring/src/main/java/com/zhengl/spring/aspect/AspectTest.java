package com.zhengl.spring.aspect;

import com.zhengl.spring.staticproxy.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectTest {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext-aspect.xml");
        UserService userService = (UserService) ctx.getBean("userService");

        userService.login("aspect", "111111");
        userService.register(new User());
    }
}
