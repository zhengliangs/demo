package com.zhengl.designmode.strategy;

/**
 * 需要参与比较的对象可实现此接口，并重写 compare 方法，实现自己的比较规则
 * @author hero良
 */
public interface Comparable<T> {

    int compareTo(T t);
}
