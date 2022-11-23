package com.zhengl.designmode.proxy.cglibproxy;

/**
 * @author hero良
 */
public class Movie {

    public String play(String name){
        System.out.println("开始播放电影...");
        return "hello  " + name;
    }

}
