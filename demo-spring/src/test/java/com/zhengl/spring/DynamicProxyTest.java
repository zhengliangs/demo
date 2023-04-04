package com.zhengl.spring;

import com.zhengl.spring.staticproxy.User;
import com.zhengl.spring.staticproxy.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DynamicProxyTest {

    /**
     * MethodInterceptor 可以在目标方法执行之前或者之后执行额外功能
     *
     * MethodInterceptor 前、后、前后 都可以执行额外功能
     * @author hero良
     */
    @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext-proxy.xml");
        UserService service = (UserService) ctx.getBean("userService");

        service.login("name", "password");
        service.register(new User());

    }

}
