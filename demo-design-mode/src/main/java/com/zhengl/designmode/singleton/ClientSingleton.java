package com.zhengl.designmode.singleton;

/**
 * 单例模式
 * @author hero良
 * @classname SingletonTest
 */
public class ClientSingleton {

    public static void main(String[] args) {
        EnumSingleton s1 = EnumSingleton.INSTANCE;
        EnumSingleton s2 = EnumSingleton.INSTANCE;
        System.out.println(s1.hashCode() == s2.hashCode());

        System.out.println(EnumSingleton.INSTANCE.fun());
    }
}
