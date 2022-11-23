package com.zhengl.designmode.composite.safety;

/**
 * @author hero良
 */
public class CompanyLeaf extends CompanyComponent {

    public CompanyLeaf(Integer id, String name, int level) {
        super(id, name, level);
    }

    @Override
    protected void print() {
        for (int i = 0; i < level; i++) System.out.print("--");

        System.out.println("id = " + id + "， name = " + name);
    }
}
