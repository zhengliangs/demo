package com.zhengl.designmode.template;

/**
 * @author hero良
 */
public class Coffee extends Beverage{

    @Override
    void brew() {
        System.out.println("冲咖啡");
    }

    @Override
    void addCondiments() {
        System.out.println("加入 牛奶和糖");
    }
}
