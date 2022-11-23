package com.zhengl.designmode.strategy;

import java.util.Arrays;

/**
 * 策略模式
 * @author hero良
 */
public class ClientStrategy {

    public static void main(String[] args) {

        Cat[] cat = new Cat[]{new Cat(7), new Cat(3), new Cat(6)};
        Dog[] dog = new Dog[]{new Dog(7), new Dog(3), new Dog(6)};
        Sorter.sorter(dog);
        System.out.println(Arrays.toString(dog));

        // 现在看来一切都很好
        // 但是如果以猫的饭量或者年龄排序呢？可扩展性就很弱，需要修改代码
    }

}
