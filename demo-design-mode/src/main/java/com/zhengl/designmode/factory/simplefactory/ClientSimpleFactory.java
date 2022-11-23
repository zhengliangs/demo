package com.zhengl.designmode.factory.simplefactory;

/**
 * 模拟客户端
 * @author hero良
 */
public class ClientSimpleFactory {

    public static void main(String[] args) {

        new OrderPizza();

        //简单工厂模式
        new OrderPizza1();
    }
}
