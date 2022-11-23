package com.zhengl.designmode.factory.simplefactory.pizza;

/**
 * 芝士披萨
 * @author hero良
 */
public class CheesePizza extends Pizza{

    @Override
    public void production() {
        System.out.println(" 开始制作芝士披萨...");
    }
}
