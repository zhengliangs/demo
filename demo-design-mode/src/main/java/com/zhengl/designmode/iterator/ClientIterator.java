package com.zhengl.designmode.iterator;

/**
 * 迭代器模式
 *
 * 迭代器模式提供了一个可以顺序访问聚合对象中各个元素，但是不会暴露对象内部实现的方法；
 *
 * 迭代器模式的好处是可以将遍历和实现解耦，客户端不需要关心容器内部的实现，只需要对客户端提供一个变量元素的迭代器就可以；
 * 而缺点就是对于简单的数组或者有序列表，会让程序看起来更复杂；
 * @author hero良
 */
public class ClientIterator {

    public static void main(String[] args) {
        DinerMenu<MenuItem> dinerMenu= new DinerMenu<>();
        Iterator<MenuItem> itDiner = dinerMenu.iterator();
        print(itDiner);

        CoffeeMenu<MenuItem> coffeeMenu = new CoffeeMenu<>();
        Iterator<MenuItem> itCoffee = coffeeMenu.iterator();
        print(itCoffee);
    }

    private static void print(Iterator<MenuItem> it){
        while (it.hasNext()){
            MenuItem next = it.next();
            System.out.println(next.toString());
        }
    }
}
