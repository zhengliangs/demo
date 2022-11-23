package com.zhengl.designmode.factory.simplefactory;

import com.zhengl.factory.simplefactory.pizza.CheesePizza;
import com.zhengl.factory.simplefactory.pizza.Pizza;
import com.zhengl.factory.simplefactory.pizza.SeafoodPizza;

/**
 * 简单工厂
 * @author hero良
 */
public class SimpleFactory {

    /**
     * 制作披萨的过程统一在工厂中，工厂可以根据不同的需求生产不同的披萨（产品）实例
     * @author hero良
     */
    public static Pizza createPizza(String pizzaType) {
        System.out.println(" 由简单工厂模式提供 ");
        Pizza pizza = null;
        if ("cheese".equals(pizzaType)) {
            pizza = new CheesePizza();
        } else if ("seafood".equals(pizzaType)) {
            pizza = new SeafoodPizza();
        }
        return pizza;
    }

}
