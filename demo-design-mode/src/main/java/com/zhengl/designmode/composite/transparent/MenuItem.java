package com.zhengl.designmode.composite.transparent;

/**
 * 菜单项 - 叶子节点
 * @author hero良
 */
public class MenuItem extends MenuComponent{

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public void print() {
        System.out.print("name = " + name);
        System.out.print("  description = " + description);
        if(vegetarian) System.out.print("  vegetarian = " + "素食  ");
        System.out.println("  price = " + price);
    }
}
