package com.zhengl.designmode.template;

/**
 * 模板模式
 * @author hero良
 */
public class ClientTemplate {

    public static void main(String[] args) {
        // 冲咖啡
        Beverage coffee = new Coffee();
        coffee.make();

        System.out.println("----------------------------");

        // 泡茶
        Beverage tea = new Tea();
        tea.make();
    }
}
