package com.zhengl.designmode.factory.simplefactory;

import com.zhengl.factory.simplefactory.pizza.Pizza;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author hero良
 */
public class OrderPizza1 {

    /**
     * 将生产披萨的过程放到披萨工厂中，具体披萨的生产由工厂来完成
     */
    public OrderPizza1(){

        do {
            Pizza pizza = SimpleFactory.createPizza(getType());
            if(pizza == null){
                System.out.println(" 输入的pizza不存在...");
                return;
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
