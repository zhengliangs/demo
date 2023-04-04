package com.zhengl.spring.dynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Around implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("-----额外功能 log-----");
        Object ret = methodInvocation.proceed();

        return ret;
    }
}

