package com.zhengl.aop.aspectj;

import com.zhengl.aop.annotation.Log;
import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author hero良
 *
 * 测试同一个切面，同一个方法增强，那个先执行
 * 结论：无法确定那个先执行
 */
@Aspect
@Component
@Order(1)
public class AnnotationAspect {

    // 只增强使用了 Log 注解的方法
    @After("@annotation(com.zhengl.aop.annotation.Log)")
    public void after(JoinPoint joinPoint) {
        System.out.println("  after  ");
        getAnnotationLog(joinPoint);
    }

    @After("@annotation(com.zhengl.aop.annotation.Log)")
    public void after1(JoinPoint joinPoint) {
        System.out.println("  after1  ");
    }

    /**
     * 是否存在注解，如果存在就获取
     */
    private Log getAnnotationLog(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null) {
            Log annotation = method.getAnnotation(Log.class);
            System.out.println("annotation == " + annotation);
            return annotation;
        }
        return null;
    }

}
