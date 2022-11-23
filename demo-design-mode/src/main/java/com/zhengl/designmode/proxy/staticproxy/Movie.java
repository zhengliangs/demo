package com.zhengl.designmode.proxy.staticproxy;

/**
 * 集体的电影
 * @author hero良
 */
public class Movie implements IMovie {

    @Override
    public void play() {
        System.out.println("正在播放 《肖申克的救赎》");
    }
}
