package com.zhengl.designmode.proxy.staticproxy;

/**
 * @author hero良
 */
public class ClientStaticProxy {

    public static void main(String[] args) {
        // 创建目标对象
        Movie movie = new Movie();
        // 创建代理对象，把目标对象传进去
        MovieProxy movieProxy = new MovieProxy(movie);
        // 调用代理对象的方法，代理对象会调用目标对象的方法
        movieProxy.play();
    }

}
