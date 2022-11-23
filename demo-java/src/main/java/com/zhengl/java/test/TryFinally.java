package com.zhengl.java.test;

/**
 * 测试try之后finally是否会修改返回值
 * 针对不同情况
 * 1. finally中调用了可调api会修改返回值
 * 2. finally调用了不可调api不会修改返回值
 * @author hero良
 * @classname TryFinally
 */
public class TryFinally {

    public static void main(String[] args) {
        TryFinally tryFinally = new TryFinally();

        int num = tryFinally.noUpdateResult();
        // 10
        System.out.println("num == " + num);

        StringBuilder sb = tryFinally.updateResult();
        // hello world!!!
        System.out.println("sb == " + sb);
    }

    /**
     * 不会修改返回值
     * @author hero良
     * @date 2022/9/30
     */
    public int noUpdateResult() {
        int i = 10;
        try {
            return i;
        } catch (Exception e) {
            return i;
        } finally {
            i = 20;
        }
    }

    /**
     * 会修改返回值
     * @author hero良
     * @date 2022/9/30
     */
    public StringBuilder updateResult() {
        StringBuilder sb = new StringBuilder("hello ");
        try {
            sb.append("world");
            return sb;
        } catch (Exception e) {
            return sb;
        } finally {
            sb.append("!!!");
        }
    }

}