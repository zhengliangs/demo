package com.zhengl.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAround {

    @Pointcut("execution(* login(..))")
    public void logExtra() {}

    @Around(value = "logExtra()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println(" ---aspect log--- ");
        Object ret = joinPoint.proceed();
        return ret;
    }

    @Around(value = "logExtra()")
    public Object tx(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println(" ---aspect tx--- ");
        Object ret = joinPoint.proceed();
        return ret;
    }
}
