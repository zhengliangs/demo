package com.zhengl.aop.aspectj;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author hero良
 */
/*
  总结

  JoinPoint 对象可以得到以下信息

      getArgs() 返回目标方法的参数
      getSignature() 返回目标方法的签名
      getTarget() 返回被代理的对象
      getThis() 返回aop为目标对象生成的代理对象

  ProceedingJoinPoint 对象是环绕通知出入的参数，通过调用proceed来执行目标方法

  所有的通知都可以使用 execution 定义表达式，也可以使用 @Pointcut 的签名
 */
// 告诉Spring这是个切面类
@Aspect
@Component
public class LogAspectj {

    /**
     * 定义一个通知签名
     * execution(方法修饰符(可选)  返回类型  类路径 方法名  参数  异常模式(可选))
     *
     * 第1个 * 表示返回值类型
     * com.zfw.demo.aop.service.* 表示包下面的所有类
     * 第3个 * 表示所有方法
     * .. 表示0个或多个参数
     */
    // Pointcut 表达式
    @Pointcut("execution(* com.zhengl.aop.service.*.*(String, int))")
    // Pointcut 签名, 切入点的名称
    public void log(){}

    /**
     * 环绕通知
     * 必须传 ProceedingJoinPoint
     *
     * 进入增强方法后，调用 ProceedingJoinPoint.proceed 方法，目标方法才会继续执行，不然目标方法不会被执行
     * 但是 @Before 前置通知会执行，@After 不会
     *
     * 环绕通知通过 ProceedingJoinPoint.proceed(Object[]) 来修改目标方法的入参，
     * proceed 方法中的数组会传给目标方法，如果数据长度和类型与目标方法不一致，程序会抛出异常
     */
    @Around("execution(* com.zhengl.aop.service.*.doAround(String, int))")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{

        Object[] args = joinPoint.getArgs();
        Object old = args[0];
        System.out.println("原目标方法的参数为 " + old);
        args[0] = "lisi";
        return joinPoint.proceed(args);
    }

    /**
     * 前置通知
     * 在目标方法被调用前执行，可以用来记录 log，权限校验，请求的url和用户的ip
     */
    @Before("execution(* com.zhengl.aop.service.*.doBefore(String))")
    public void doBefore(JoinPoint joinPoint){
        // 参数
        Object[] args = joinPoint.getArgs();
        System.out.println("参数 == " + Arrays.asList(args));

        Signature signature = joinPoint.getSignature();
        System.out.println("方法名 == " + signature.getName());
        System.out.println("类名 == " + signature.getDeclaringTypeName());

        // 被织入增强的对象，也就是被代理的对象
        // com.zhengl.aop.service.UserService@3b05f2ba
        System.out.println("被代理的对象 == " + joinPoint.getTarget());

        // 为目标对象生成的代理对象
        // com.zhengl.aop.service.UserService@3b05f2ba
        System.out.println("aop为目标对象生成的代理对象 == " + joinPoint.getThis());
    }

    /**
     * 后置通知
     * 和前置通知对应，可以和前置通知配合使用，记录接口的执行时间，也可以记录返回值
     */
    @After("execution(* com.zhengl.aop.service.*.doAfter(String))")
    public void doAfter(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();

        String name = signature.getName();
        String declaringTypeName = signature.getDeclaringTypeName();

        System.out.println(declaringTypeName + " 包中的 " + name + "方法执行完了");
    }

    /**
     * 最终通知
     * 接受 (JoinPoint, Object) 两个参数，
     * Object 需要是在 AfterReturning 中 returning 声明的, 值为目标方法的返回值
     * 如果目标方法没有返回值，但是传入了 returning ，就不会进入通知，如果参数类型不匹配也不会进入通知
     * 注意 虽然可以得到目标方法的返回值，但是不能修改目标方法的返回值
     */
    @AfterReturning(value = "execution(* com.zhengl.aop.service.*.doAfterReturning*(..))", returning = "obj")
    public void doAfterReturning(JoinPoint joinPoint, Object obj){
        String name = joinPoint.getSignature().getName();
        System.out.println("方法 " + name + " 执行完毕，返回值为 " + obj);
        // 实际开发中可以处理返回值
        System.out.println(obj + " - 增强版");
    }

    /**
     * 异常通知
     * 只有目标方法发生异常的时候才会进去，不管异常是否被try{}catch
     * throwing: 目标方法抛出的异常，需要和参数一致，否则报错
     */
    @AfterThrowing(value = "(execution(* com.zhengl.aop.service.*.doAfterThrowing(int)))", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e){
        Signature signature = joinPoint.getSignature();
        String declaringTypeName = signature.getDeclaringTypeName();
        String name = signature.getName();
        System.out.println(declaringTypeName + " 包下的 " + name + " 抛出了异常，异常为 " + e.getMessage() + e);
    }

}
