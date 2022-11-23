package com.zhengl.designmode.iterator;

/**
 * 迭代器接口，定义了遍历元素的方法
 * @author hero良
 */
public interface Iterator<E> {

    boolean hasNext();

    E next();

    void remove();
}
