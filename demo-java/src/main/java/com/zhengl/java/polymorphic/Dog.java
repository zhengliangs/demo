package com.zhengl.java.polymorphic;

/**
 * @author hero良
 * @classname Dog
 */
public class Dog extends Animal{

    @Override
    public void fun() {
        super.fun();
        System.out.println("Dog fun");
    }
}
