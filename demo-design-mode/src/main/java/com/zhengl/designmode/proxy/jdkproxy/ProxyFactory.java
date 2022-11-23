package com.zhengl.designmode.proxy.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @author hero良
 */
public class ProxyFactory {

    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    // newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
    // loader：加载目标对象的类加载器
    // interfaces: 目标对象实现的接口,如果目标对象没有实现接口，会报错，所以说JDK的动态代理也是接口代理
    // h：调用处理器，定义了代理对象中需要执行的具体操作
    public Object newProxyInstance(){
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(),
                this.target.getClass().getInterfaces(),
                // proxy: 执行这个方法的代理对象
                // method: 实际需要执行的方法
                // args: 实际方法的参数
                (proxy, method, args) -> {
                    before();
                    Object invoke = method.invoke(target, args);
                    after();
                    return invoke;
                });
    }

    private void before(){
        System.out.println("jdk动态代理 -- 电影开始前播放广告...");
    }

    private void after(){
        System.out.println("jdk动态代理 -- 电影结束后播放广告...");
    }

}
