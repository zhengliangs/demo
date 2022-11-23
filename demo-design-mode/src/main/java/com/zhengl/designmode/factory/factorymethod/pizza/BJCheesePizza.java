package com.zhengl.designmode.factory.factorymethod.pizza;

/**
 * 芝士披萨
 * @author hero良
 */
public class BJCheesePizza extends Pizza {

    @Override
    public void production() {
        System.out.println(" 开始制作芝士披萨...");
    }
}
