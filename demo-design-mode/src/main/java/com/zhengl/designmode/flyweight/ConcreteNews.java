package com.zhengl.designmode.flyweight;

/**
 * @author hero良
 */
public class ConcreteNews implements INewsFlyweight{

    // 共享部分，新闻发布的方式
    private String type;

    public ConcreteNews(String type) {
        this.type = type;
    }

    @Override
    public void publish() {
        System.out.println("新闻以[" + this.type + "]方式发布");
    }
}
