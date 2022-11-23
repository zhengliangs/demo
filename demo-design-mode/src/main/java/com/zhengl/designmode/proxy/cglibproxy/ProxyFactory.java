package com.zhengl.designmode.proxy.cglibproxy;

import java.lang.reflect.Method;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author hero良
 */
// 需要实现 MethodInterceptor 接口
public class ProxyFactory implements MethodInterceptor {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // 返回代理对象的实例
    public Object getInstance(){
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(this.target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        //创建子类
        return enhancer.create();
    }

    // 重写 intercept 方法，调用目标对象方法的时候会被 intercept 方法拦截
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        before();
        Object res = method.invoke(target, args);
        after();
        return res;
    }

    private void before(){
        System.out.println("cglib -- 电影开始前播放广告...");
    }

    private void after(){
        System.out.println("cglib -- 电影结束后播放广告...");
    }
}
