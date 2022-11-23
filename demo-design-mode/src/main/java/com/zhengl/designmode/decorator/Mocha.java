package com.zhengl.designmode.decorator;

/**
 * 摩卡是装饰者，需要继承装饰者类
 * @author hero良
 */
public class Mocha extends CondimentDecorator{

    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        // 饮料的价钱加上调料的价钱
        return beverage.cost() + 0.7;
    }
}
