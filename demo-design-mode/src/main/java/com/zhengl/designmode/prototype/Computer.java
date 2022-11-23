package com.zhengl.designmode.prototype;

/**
 * @author hero良
 */
public class Computer implements Cloneable {

    private String model;
    private double price;
    //引用类型
    private Producer producer;

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Computer(String model, double price, Producer producer) {
        this.model = model;
        this.price = price;
        this.producer = producer;
    }

    @Override
    public Computer clone() throws CloneNotSupportedException {
        Computer clone = (Computer)super.clone();
        clone.setProducer(clone.producer.clone());
        return clone;
    }
}
