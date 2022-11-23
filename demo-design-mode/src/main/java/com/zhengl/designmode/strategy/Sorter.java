package com.zhengl.designmode.strategy;

/**
 * @author hero良
 */
public class Sorter<T> {

    // 可以接受实现了Comparable接口的任意对象数组，进行排序
    public static void sorter(Comparable[] arr) {
        for (int i = 0; i < arr.length -1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                min = arr[j].compareTo(arr[min]) == -1 ? j : min;
            }
            Comparable temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public void sorter(T t, Comparable[] arr) {
        for (int i = 0; i < arr.length -1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                min = arr[j].compareTo(arr[min]) == -1 ? j : min;
            }
            Comparable temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }


    /**
     * 冒泡排序
     */
    public static void bubble(int[] arr) {
        // 控制数组比较的次数
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                // 前一个数大于后一个数
                if (arr[j] > arr[j + 1]) {
                    // 将前一个数存入临时变量
                    int temp = arr[j];
                    // 将后一个数存入到前一个数的下标中
                    arr[j] = arr[j + 1];
                    // 将临时变量中的数，存入到后一个数的下表中
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
