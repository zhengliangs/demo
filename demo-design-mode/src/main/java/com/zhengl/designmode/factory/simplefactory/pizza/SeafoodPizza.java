package com.zhengl.designmode.factory.simplefactory.pizza;

/**
 * 海鲜披萨
 * @author hero良
 */
public class SeafoodPizza extends Pizza{

    @Override
    public void production() {
        System.out.println(" 开始制作海鲜披萨...");
    }
}
