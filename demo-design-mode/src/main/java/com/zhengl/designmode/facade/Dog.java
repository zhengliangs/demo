package com.zhengl.designmode.facade;

/**
 * 狗
 * @author hero良
 */
public class Dog implements Animal{

    @Override
    public void draw() {
        System.out.println("开始画 [狗]");
    }
}
