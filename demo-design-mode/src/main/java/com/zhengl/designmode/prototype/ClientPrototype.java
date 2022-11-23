package com.zhengl.designmode.prototype;

/**
 * 原型模式
 * @author hero良
 */
public class ClientPrototype {

    public static void main(String[] args) {
        Producer producer = new Producer("联想公司制造", "昆山");
        Computer thinkPad = new Computer("thinkPad", 8000, producer);

        try {
            Computer thinkPad1 = thinkPad.clone();

            int think1 = thinkPad.getProducer().hashCode();
            int think2 = thinkPad1.getProducer().hashCode();

            // false
            System.out.println(think1 == think2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
