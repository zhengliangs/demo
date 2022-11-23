package com.zhengl.designmode.facade.decorator;

/**
 * 装饰者模式
 * @author hero良
 */
public class ClientDecorator {

    public static void main(String[] args) {
        // 需求: 需要一杯浓缩咖啡 + 摩卡
        // 1. 先创建一杯浓缩咖啡
        Beverage espresso = new Espresso();
        // 2. 再摩卡来装饰
        espresso = new Mocha(espresso);
        // Espresso, Mocha $ = 2.59
        System.out.println(espresso.getDescription() + " $ = " + espresso.cost());

        // 需求: 需要一杯综合咖啡 + 摩卡 + 豆浆
        // 1. 创建一杯综合咖啡
        Beverage houseBlend = new HouseBlend();
        // 2. 用摩卡来装饰
        houseBlend = new Mocha(houseBlend);
        // 3. 在用豆浆来装饰
        houseBlend = new Soy(houseBlend);
        // Espresso, Mocha, soy $ = 2.19
        System.out.println(houseBlend.getDescription() + " $ = " + houseBlend.cost());
    }
}
