package com.zhengl.designmode.iterator;

import java.util.ArrayList;

/**
 * 咖啡菜单 - 具体的容器
 * @author hero良
 */
public class CoffeeMenu<E> implements Menu<E> {

    // 咖啡菜单是用list来保存
    private ArrayList menuItems;

    public CoffeeMenu() {
        menuItems = new ArrayList<>();
        addItem("美式咖啡", 53);
        addItem("欧式咖啡", 31);
        addItem("牛奶咖啡", 41.5);
        addItem("豆浆咖啡", 12.5);
    }

    void addItem(String name, double price){
        MenuItem menuItem = new MenuItem(name, price);
        menuItems.add(menuItem);
    }

    @Override
    public Iterator<E> iterator() {
        return new CoffeeIterator();
    }

    // 具体的迭代器实现，内部类的方式
    private class CoffeeIterator implements Iterator<E> {

        private int position;

        @Override
        public boolean hasNext() {
            if(position >= menuItems.size() - 1 || menuItems.get(position) == null){
                return false;
            }
            return true;
        }

        @Override
        public E next() {
            E e = (E)menuItems.get(position);
            position += 1;
            return e;
        }

        @Override
        public void remove() {

        }
    }
}
