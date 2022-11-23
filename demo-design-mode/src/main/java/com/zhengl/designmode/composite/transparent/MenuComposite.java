package com.zhengl.designmode.composite.transparent;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单组合，包含菜单、菜单项 - 树枝节点
 * @author hero良
 */
public class MenuComposite extends MenuComponent{

    // 存放菜单和菜单项
    private List<MenuComponent> componentList = new ArrayList<>();

    public MenuComposite(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        componentList.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        componentList.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return componentList.get(i);
    }

    @Override
    public void print() {
        System.out.print("name = " + name);
        System.out.println("  description = " + description);

        for (MenuComponent menuComponent : componentList) {
            menuComponent.print();
        }
    }
}
