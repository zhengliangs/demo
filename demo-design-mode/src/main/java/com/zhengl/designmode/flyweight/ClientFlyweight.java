package com.zhengl.designmode.flyweight;

/**
 * 享元模式
 * @author hero良
 */
public class ClientFlyweight {

    public static void main(String[] args) {
        NewsFactory factory = new NewsFactory();

        INewsFlyweight tx = factory.getNews("腾讯");
        tx.publish();

        INewsFlyweight tt = factory.getNews("头条");
        tt.publish();

        INewsFlyweight xl = factory.getNews("新浪");
        xl.publish();

        INewsFlyweight tt1 = factory.getNews("头条");
        tt1.publish();

        System.out.println(factory.getNewsCount());
    }

}
