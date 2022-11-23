package com.zhengl.designmode.iterator;

/**
 * 餐厅菜单 - 具体的容器
 * @author hero良
 */
public class DinerMenu<E> implements Menu<E>{

    static final int MAX_ITEMS = 5;
    // 餐厅菜单是用数组来保存
    private MenuItem[] menuItems;
    // 记录现在数组中存放了多少个元素
    private int numberOfItem = 0;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEMS];
        addItem("水煮鱼", 53);
        addItem("小龙虾", 31);
        addItem("八爪鱼", 41.5);
        addItem("臭豆腐", 12.5);
    }

    void addItem(String name, double price){
        if(numberOfItem >= MAX_ITEMS){
            throw new RuntimeException("超出了数组最大容量...");
        } else {
            MenuItem menuItem = new MenuItem(name, price);
            menuItems[numberOfItem] = menuItem;
            // +1
            numberOfItem += 1;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new DinerIterator();
    }

    // 具体的迭代器实现，内部类的方式
    private class DinerIterator implements Iterator<E> {

        // 记录元素遍历的位置
        private int position;

        @Override
        public boolean hasNext() {
            if(position >= menuItems.length || menuItems[position] == null){
                return false;
            }
            return true;
        }

        @Override
        public E next() {
            E e = (E)menuItems[position];
            position += 1;
            return e;
        }

        @Override
        public void remove() {

        }
    }

}
