package com.zhengl.spring.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * BeanPostProcessor /ˈprɑːsesər/ 对Spring工厂创建的对象，进行再加工
 * 但是在实战中很少处理Spring的初始化操作，所以没必要区分Before和After，只需要实现其中一个方法就可以；通常来实现After，应该After是后置；
 * @author hero良
 * @date 2023/3/10
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     *  在Spring工厂创建完对象，并进行注入后，会执行Before方法
     * @author hero良
     * @date 2023/3/10
     * @param bean bean 对象
     * @param beanName applicationConText.xml 中的id属性
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    /**
     *  在Spring执行完对象的初始化操作后边，会执行After方法
     * @author hero良
     * @date 2023/3/10
     * @param bean bean 对象
     * @param beanName applicationConText.xml 中的id属性
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //
        if (bean instanceof Category) {
            Category category = (Category) bean;
            category.setName("xiaowb");
        }
        return bean;
    }
}
