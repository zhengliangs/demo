package com.zhengl.spring.dynamicproxy;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyMethodBeforeAdvice implements MethodBeforeAdvice {

    /*
        Method: 额外功能所增加给的那个原始方法(login/register)
        Object[]: 额外功能所增加给的那个原始方法的参数(String username, String password/new User)
        Object: 额外功能所增加给的那个原始对象(UserServiceImpl)
     */
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("----------before log---------");
    }
}
