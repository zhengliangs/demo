package com.zhengl.spring;

import com.zhengl.spring.basic.Person;
import com.zhengl.spring.beanpost.Category;
import com.zhengl.spring.converter.Order;
import com.zhengl.spring.factorybean.ConnectionFactoryBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

public class SpringTest {

    // 获取简单对象
    @Test
    public void test1() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Person person = (Person) ctx.getBean("person");

        System.out.println("person = " + person.toString());
    }

    // 获取复杂对象
    @Test
    public void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection conn = (Connection) ctx.getBean("conn");

        System.out.println("conn = " + conn);
    }

    @Test
    public void test3() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        ConnectionFactoryBean conn = (ConnectionFactoryBean) ctx.getBean("&conn");

        System.out.println("conn = " + conn);
    }

    // 实例工厂
    @Test
    public void test4() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection connFac = (Connection) ctx.getBean("connFac");

        System.out.println("connFac = " + connFac);
    }

    // 静态工厂
    @Test
    public void test5() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection connStaFac = (Connection) ctx.getBean("connStaFac");

        System.out.println("connStaFac = " + connStaFac);
    }

    // 类型转换器
    @Test
    public void test6() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Order order = (Order) ctx.getBean("order");

        System.out.println("order = " + order);
    }

    // BeanPostProcessor
    @Test
    public void test7() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Category category = (Category) ctx.getBean("category");

        System.out.println("category = " + category.toString());
    }
}
