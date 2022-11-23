package com.zhengl.designmode.iterator;

/**
 * @author hero良
 */
public class MenuItem {

    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
