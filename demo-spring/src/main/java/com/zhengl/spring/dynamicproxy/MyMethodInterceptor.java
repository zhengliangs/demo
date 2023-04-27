package com.zhengl.spring.dynamicproxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("-----around log-----");
        Object ret = methodInvocation.proceed();

        return ret;
    }
}

