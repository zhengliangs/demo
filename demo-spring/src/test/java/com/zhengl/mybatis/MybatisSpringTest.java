package com.zhengl.mybatis;

import com.zhengl.mybatis.dao.UserMapper;
import com.zhengl.mybatis.entity.User;
import com.zhengl.mybatis.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MybatisSpringTest {

    @Test
    public void test1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext-mybatis.xml");
        UserMapper userMapper = (UserMapper) ctx.getBean("userMapper");

        User user = new User();
        user.setName("test1");
        user.setPassword("111111");
        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);
    }
    
    /**
     * 测试Spring的事务处理
     * @author hero良
     * @date 2023/4/27
     */
    @Test
    public void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext-mybatis.xml");
        UserService userService = (UserService) ctx.getBean("userService");

        User user = new User();
        user.setName("test22");
        user.setPassword("222222");
        boolean register = userService.register(user);
        System.out.println("register = " + register);
    }
}
