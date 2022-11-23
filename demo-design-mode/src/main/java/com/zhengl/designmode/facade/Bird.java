package com.zhengl.designmode.facade;

/**
 * 鸟
 * @author hero良
 */
public class Bird implements Animal{

    @Override
    public void draw() {
        System.out.println("开始画 [鸟]");
    }
}
