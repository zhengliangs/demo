package com.zhengl.designmode.proxy.jdkproxy;

/**
 * jdk代理
 * @author hero良
 */
public class ClientJDKProxy {

    public static void main(String[] args) {
        Movie movie = new Movie();
        IMovie movieProxy = (IMovie)new ProxyFactory(movie).newProxyInstance();

        System.out.println(movieProxy.getClass());
        movieProxy.dynamicPlay();

        boolean res = movieProxy.speed(1.5, "肖申克的救赎");
        System.out.println("res == " + res);
    }

}
