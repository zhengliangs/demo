package com.zhengl.designmode.prototype;

/**
 * @author hero良
 */
public class Producer implements Cloneable {

    private String name;
    private String address;

    public Producer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public Producer clone() throws CloneNotSupportedException {
        return (Producer)super.clone();
    }
}
