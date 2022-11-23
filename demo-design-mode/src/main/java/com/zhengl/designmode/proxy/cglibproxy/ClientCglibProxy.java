package com.zhengl.designmode.proxy.cglibproxy;

/**
 * 代理模式
 * @author hero良
 */
public class ClientCglibProxy {

    public static void main(String[] args) {
        Movie movie = new Movie();
        Movie movieProxy = (Movie)new ProxyFactory(movie).getInstance();

        String res = movieProxy.play("肖申克的救赎");
        System.out.println("res == " + res);
    }

}
