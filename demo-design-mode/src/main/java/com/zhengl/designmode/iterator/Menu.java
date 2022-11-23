package com.zhengl.designmode.iterator;

/**
 * 抽象容器, 提供一个创建迭代器的方法；比如jdk中的Collection、List、Set；
 * @author hero良
 */
public interface Menu<T> {

    Iterator<T> iterator();
}
