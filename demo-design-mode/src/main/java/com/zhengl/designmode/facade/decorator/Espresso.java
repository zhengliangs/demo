package com.zhengl.designmode.facade.decorator;

/**
 * 浓缩咖啡 - 一种饮料
 * @author hero良
 * @classname Espresso
 */
public class Espresso implements Beverage{

    private final String description;

    public Espresso() {
        this.description = "Espresso";
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double cost() {
        return 1.89;
    }
}
