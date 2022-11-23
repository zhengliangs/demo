package com.zhengl.java.polymorphic;

/**
 * @author hero良
 * @classname Cat
 */
public class Cat extends Animal {

    @Override
    public void fun() {
//        super.fun();
        System.out.println("Cat fun");
    }

    public void fun1(){
        System.out.println("Cat fun1");
    }
}
