package com.zhengl.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MyAround {

    @Around("execution(* login(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println(" ---aspect log--- ");
        Object ret = joinPoint.proceed();
        return ret;
    }
}
