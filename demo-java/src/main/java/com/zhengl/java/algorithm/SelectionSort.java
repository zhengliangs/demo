package com.zhengl.java.algorithm;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {2, 6, 1, 9, 3, 5, 7, 8, 4};
        selection(array);
    }

    public static void selection(int[] array) {
        // i 代表每轮选择最小元素要交换到的目标索引
        for (int i = 0; i < array.length - 1; i++) {
            // s 代表每轮选择后的最小元素
            int s = i;
            for (int j = s + 1; j < array.length; j++) {
                if (array[s] > array[j]) {
                    s = j;
                }
            }
            //
            if (s != i) {
                // 后一个临时存起来
                int temp = array[s];
                // 将前一个赋值给后一个
                array[s] = array[i];
                // 临时变量赋值给前一个
                array[i] = temp;
            }
            System.out.println(Arrays.toString(array));
        }
    }
}
