package com.zhengl.designmode.proxy.staticproxy;

/**
 * @author hero良
 */
public class MovieProxy implements IMovie{

    private IMovie target;

    public MovieProxy(IMovie target) {
        this.target = target;
    }

    @Override
    public void play() {
        before();
        this.target.play();
        after();
    }

    private void before(){
        System.out.println("电影开始前播放广告...");
    }

    private void after(){
        System.out.println("电影结束后播放广告...");
    }
}
