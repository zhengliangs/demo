package com.zhengl.designmode.builder.classic;

/**
 * 常用建造者模式
 * @author hero良
 */
public class ClassicClientBuilder {

    public static void main(String[] args) {
        Computer macos = new Computer.Builder()
                .computerModel("macos")
                .cpu("i7", "因特尔")
                //.height(1.3) 可选
                .build();

        System.out.println(macos);
    }
}
