package com.zhengl.designmode.composite.safety;

/**
 * @author hero良
 */
public abstract class CompanyComponent {

    protected Integer id;
    protected String name;
    protected int level;

    public CompanyComponent(Integer id, String name, int level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    protected abstract void print();
}
