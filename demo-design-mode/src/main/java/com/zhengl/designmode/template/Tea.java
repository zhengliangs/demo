package com.zhengl.designmode.template;

/**
 * @author hero良
 */
public class Tea extends Beverage{

    @Override
    void brew() {
        System.out.println("泡茶");
    }

    @Override
    void addCondiments() {
        System.out.println("加入 枸杞");
    }

    @Override
    boolean isAddCondiments() {
        return false;
    }
}
