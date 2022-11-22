package com.zhengl.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author hero良
 *
 * 测试使用 Order 定义优先级
 * 结论：并不能确定同一个方法在不同的切面中执行同一个增强类型，优先级高的切面会先执行
 */
@Aspect
@Component
@Order(4)
public class AnnotationAspectCy {

    // 只增强使用了 Log 注解的方法
    @After("@annotation(com.zhengl.aop.annotation.Log)")
    public void after(JoinPoint joinPoint) {
        System.out.println("  cp after  ");
    }

}
