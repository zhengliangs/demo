package com.zhengl.designmode.facade.decorator;

/**
 * @author hero良
 */
public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", soy";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.5;
    }
}
