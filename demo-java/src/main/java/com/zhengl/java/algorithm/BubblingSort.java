package com.zhengl.java.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author hero良
 * @date 2022/8/17
 */
public class BubblingSort {

    public static void main(String[] args) {
        int[] array = {2, 6, 1, 9, 3, 5, 7, 8, 4};

        System.out.println(" bubbling ------------------------------");
        bubbling(array);
        System.out.println(" bubbling_v1 ------------------------------");
        bubbling_v1(array);
        System.out.println(" bubbling_v2 ------------------------------");
        int[] array2 = {2, 6, 1, 9, 3, 5, 7, 8, 4};
        bubbling_v2(array2);
    }

    /**
     * 标准冒泡排序
     * @author hero良
     * @date 2022/8/17
     */
    public static void bubbling(int[] array) {
        // 比较次数
        for (int i = 0; i < array.length - 1; i++) {
            // j < array.length - 1 - i;
            // -i 因为每比较一次,就会有一个元素冒泡成功,就不需要再比较了
            for (int j = 0; j < array.length - 1 - i; j++) {
                // 前一个 > 后一个 交换位置
                if (array[j] > array[j + 1]){
                    // 后一个临时存起来
                    int temp = array[j + 1];
                    // 将前一个赋值给后一个
                    array[j + 1] = array[j];
                    // 临时变量赋值给前一个
                    array[j] = temp;
                }
            }
            System.out.println("第" + i + "轮冒泡" + Arrays.toString(array));
        }
    }

    /**
     * 优化比较次数，加一个标识，如果没有发生交换，就结束比较
     * 增加一个标识，如果没有发生交换，证明数组已经排好序，就不需要再进行比较了
     * @author hero良
     * @date 2022/8/17
     */
    public static void bubbling_v1(int[] array){
        // 比较次数
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            // j < array.length - 1 - i;
            // -i 因为每比较一次,就会有一个元素冒泡成功,就不需要再比较了
            for (int j = 0; j < array.length - 1 - i; j++) {
                System.out.println("比较次数" + j);
                // 前一个 > 后一个 交换位置
                if (array[j] > array[j + 1]){
                    // 后一个临时存起来
                    int temp = array[j + 1];
                    // 将前一个赋值给后一个
                    array[j + 1] = array[j];
                    // 临时变量赋值给前一个
                    array[j] = temp;

                    // 发生了交换
                    flag = true;
                }
            }
            // 如果没有发生交换，表示已经排好序，结束比较
            if (!flag) {
                break;
            }
            System.out.println("第" + i + "轮冒泡" + Arrays.toString(array));
        }
    }

    public static void bubbling_v2(int[] array){
        int i = 1;
        int n = array.length - 1;
        while (true){
            // 最后一次交换索引的位置
            int last = 0;

            for (int j = 0; j < n; j++) {
                System.out.println("比较次数" + j);
                if (array[j] > array[j + 1]){
                    // 后一个临时存起来
                    int temp = array[j + 1];
                    // 将前一个赋值给后一个
                    array[j + 1] = array[j];
                    // 临时变量赋值给前一个
                    array[j] = temp;

                    last = j;
                }
            }
            n = last;
            System.out.println("第 "+ i + " 轮冒泡" + Arrays.toString(array));
            i++;
            if (last == 0) {
                break;
            }
        }
    }
}
