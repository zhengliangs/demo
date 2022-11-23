package com.zhengl.designmode.proxy.jdkproxy;

/**
 * @author hero良
 */
public class Movie implements IMovie {

    @Override
    public void dynamicPlay() {
        System.out.println("jdk -- 正在播放 《肖申克的救赎》");
    }

    @Override
    public boolean speed(double hz, String name) {
        System.out.println("hz == " + hz + "  name ==" + name);
        return true;
    }
}