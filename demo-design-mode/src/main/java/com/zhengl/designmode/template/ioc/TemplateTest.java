package com.zhengl.designmode.template.ioc;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author hero良
 */
public class TemplateTest {

    public static void main(String[] args) {
        ConfigurableApplicationContext cac = new AbstractApplicationContext() {
            @Override
            protected void refreshBeanFactory() throws BeansException, IllegalStateException {

            }

            @Override
            protected void closeBeanFactory() {

            }

            @Override
            public ConfigurableListableBeanFactory getBeanFactory() throws IllegalStateException {
                return null;
            }
        };
    }

}
