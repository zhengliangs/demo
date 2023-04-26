package com.zhengl.spring.jdkproxy;

import com.zhengl.spring.staticproxy.User;
import com.zhengl.spring.staticproxy.UserService;
import com.zhengl.spring.staticproxy.UserServiceImpl;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class JDKProxyTest {

    public static void main(String[] args) {
        // 1. 创建原始对象
        UserService userService = new UserServiceImpl();

        // 2. JDK创建动态代理
        InvocationHandler handler = new InvocationHandler() {
            /*
               Object: 额外功能所增加给的那个原始对象(UserServiceImpl)
               Method: 额外功能所增加给的那个原始方法(login/register)
               Object[]: 额外功能所增加给的那个原始方法的参数(String username, String password/new User)
            */
            @Override
            public Object invoke(Object o, Method method, Object[] args) throws Throwable {
                System.out.println("--- proxy log ---");
                // 原始方法的运行
                Object ret = method.invoke(userService, args);
                return ret;
            }
        };

        /*
            ClassLoader loader 类加载器
            Class[] interfaces 原始类实现的接口
            InvocationHandler h
         */
        UserService userServiceProxy =
                (UserService) Proxy.newProxyInstance(JDKProxyTest.class.getClassLoader(), userService.getClass().getInterfaces(), handler);

        userServiceProxy.register(new User());
        userServiceProxy.login("test", "123");
    }
}
