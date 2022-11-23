package com.zhengl.java.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hero良
 */
public class TestHashMap {

    private static final int MAXIMUM_CAPACITY = 64;

    public static void main(String[] args) {
        Map<Object, Object> map = new HashMap<>();
        map.put("","");

        int param = 4;
        System.out.println("tableSizeFor == " + tableSizeFor(param));

        Object key = "java";
        int hash = hash(key);
        int length = 16;//模拟散列表长度
        int index = (length - 1) & hash;

        /*
         * 10 1110 0011 1010 1100 0111 has二进制
         * 00 0000 0000 0000 0000 1111
         *
         * 00 0000 0000 0000 0000 0111 & 后 都为1才为1 否则为0
         *
         * 十进制 index = 7
         * 被存放到index = 7 的桶位中
         */
        System.out.println(index);
    }

    /**
     * 计算key的 hash 值
     * @author hero良
     */
    static int hash(Object key) {
        int h;
        int hashCode = key.hashCode();
        System.out.println("hashCode == " + hashCode + ",  二进制 == " + Integer.toBinaryString(hashCode));
        // 无符号右移16位
        int hashCode1 = key.hashCode() >>> 16;
        System.out.println("无符号右移16位 == " + hashCode1 + ",  二进制 == " + Integer.toBinaryString(hashCode1));

        /*
         * 10 1110 0011 1010 1110 1001   hashCode
         * 00 0000 0000 0000 0010 1110   右移16位
         *
         * 10 1110 0011 1010 1100 0111   亦或 相同为0 不同为1
         */
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * 返回比给定数大且最接近给定数的2的幂次方
     * @author hero良
     */
    static int tableSizeFor(int cap) {
        //如果不执行减 1 操作，如果传入的值是 2 的次幂，那么就会得到传入值的2倍
        int n = cap - 1;
        n |= n >>> 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 2;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 4;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 8;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 16;
        System.out.println(Integer.toBinaryString(n));
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}
