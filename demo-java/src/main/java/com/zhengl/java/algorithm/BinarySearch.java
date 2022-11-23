package com.zhengl.java.algorithm;

/**
 * 二分查找法
 * @author hero良
 */
public class BinarySearch {

    public static void main(String[] args) {
        // 有序数组
        int[] array = {1, 5, 9, 15, 17, 21, 26, 32, 55, 59, 68, 73, 77, 86, 89, 92, 94, 97};
        // 需要查找的元素
        int target = 89;
        int index = binarySearch(array, target);
        System.out.println("target index == "+ index);
    }

    public static int binarySearch(int[] arr, int data){
        // 低位
        int low = 0;
        // 高位 数组的长度
        int high = arr.length -1;
        // 中间元素下标
        int mid;

        // 循环终止条件，低位和高位相等，也就是说数组拆分的只有一个元素了
        while(low <= high){
            mid = (low + high) / 2;
            // 第mid位元素
            int source = arr[mid];

            // 第mid位元素和目标数相等，返回m(也就是下标)
            if (source == data) {
                return mid;
            } else if (source > data) {// 第mid位元素大于目标数，说明，右边界的元素都大于目标数，需要修改高位的值，-1操作，是需要抛去m位元素
                high = mid - 1;
            } else {// 第mid位元素小于目标数，说明，左边界的元素都小于目标数，需要修改低位的值，+1操作，是需要抛去m位元素
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 防止 (低位+高位)/2 内存溢出
     * @author hero良
     * @date 2022/8/18
     */
    public static int binarySearch_v1(int[] arr, int data){
        int low = 0;
        int high = arr.length -1;
        int mid;

        while(low <= high){
            // 无符号右移一位，防止内存溢出
            // 如果数组的长度特别大，低位 + 高位,就会内存溢出
            mid = (low + high) >>> 1;
            int source = arr[mid];

            if (source == data) {
                return mid;
            } else if (source > data) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

}
