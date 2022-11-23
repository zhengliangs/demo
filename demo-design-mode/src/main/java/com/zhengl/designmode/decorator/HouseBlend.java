package com.zhengl.designmode.decorator;

/**
 * 综合咖啡 - 一种饮料
 * @author hero良
 * @classname HouseBlend
 */
public class HouseBlend implements Beverage{

    private final String description;

    public HouseBlend() {
        this.description = "Espresso";
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
