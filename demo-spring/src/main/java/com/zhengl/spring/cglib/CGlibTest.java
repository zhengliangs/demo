package com.zhengl.spring.cglib;

import com.zhengl.spring.staticproxy.User;
import com.zhengl.spring.staticproxy.UserService;
import com.zhengl.spring.staticproxy.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibTest {

    public static void main(String[] args) {
        // 1. 需要先创建原始对象
        UserService userService = new UserServiceImpl();

        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(CGlibTest.class.getClassLoader());
        enhancer.setSuperclass(userService.getClass());

        MethodInterceptor interceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

                System.out.println(" ---cglib.log--- ");
                Object ret = method.invoke(userService, args);
                return ret;
            }
        };
        enhancer.setCallback(interceptor);

        UserService userServiceProxy = (UserService) enhancer.create();
        userServiceProxy.login("cglib", "123456");
        userServiceProxy.register(new User());
    }
}
