package com.zhengl.designmode.composite.transparent;

/**
 * 菜单组件 - 抽象构建
 * @author hero良
 */
public abstract class MenuComponent {

    protected String name;
    protected String description;
    protected boolean vegetarian;
    protected double price;

    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
}
