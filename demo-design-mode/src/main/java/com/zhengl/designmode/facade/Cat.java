package com.zhengl.designmode.facade;

/**
 * 猫
 * @author hero良
 */
public class Cat implements Animal{

    @Override
    public void draw() {
        System.out.println("开始画 [猫]");
    }
}
