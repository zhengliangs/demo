package com.zhengl.designmode.template;

/**
 * @author hero良
 */
public abstract class Beverage {

    // 模板方法，封装算法
    // 声明为 final 避免子类重写
    final void make(){
        boilWater();
        brew();
        pourInCup();
        if(isAddCondiments()){
            addCondiments();
        }
    }

    void boilWater(){
        System.out.println("把水煮沸");
    }
    // 子类重写
    abstract void brew();

    void pourInCup(){
        System.out.println("倒入杯子");
    }
    // 子类重写
    abstract void addCondiments();

    // 钩子方法，提供默认实现，由子类决定是否重写
    boolean isAddCondiments(){
        return true;
    }
}
