package com.zhengl.spring.factory;

import com.zhengl.spring.staticproxy.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext-beanPostProcessor.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        userService.login("processor", "123456");
        userService.register(new User());
    }
}
