package com.zhengl.designmode.facade.decorator;

/**
 * 调料抽象类/也可以是接口 - 所有装饰者的基类
 * CondimentDecorator实现了Beverage接口，这样继承CondimentDecorator
 * 的装饰者就可以取代被装饰者；也就是经过调料装饰后的饮料还是饮料
 * @author hero良
 */
public abstract class CondimentDecorator implements Beverage{

    protected Beverage beverage;

    public CondimentDecorator(Beverage beverage){
        this.beverage = beverage;
    }
}
