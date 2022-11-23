package com.zhengl.designmode.factory.simplefactory;

import com.zhengl.factory.simplefactory.pizza.CheesePizza;
import com.zhengl.factory.simplefactory.pizza.Pizza;
import com.zhengl.factory.simplefactory.pizza.SeafoodPizza;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 披萨店
 * @author hero良
 */
public class OrderPizza {

    /**
     * 如果生产披萨的过程都在各自的披萨店中，如果新增一种披萨的时候，每个披萨店都需要修改
     */
    public OrderPizza() {
        Pizza pizza;
        String pizzaType;
        do{
            pizzaType = getType();
            if ("cheese".equals(pizzaType)){
                pizza = new CheesePizza();
            } else if ("seafood".equals(pizzaType)) {
                pizza = new SeafoodPizza();
            } else {
                break;
            }
            pizza.production();
        } while (true);
    }

    /**
     * 获取控制台用户输入的披萨类型
     * @author hero良
     */
    private String getType(){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
