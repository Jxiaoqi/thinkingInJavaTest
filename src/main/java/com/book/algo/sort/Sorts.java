package com.book.algo.sort;

import access.TempTest;

/**
 * 冒泡排序、插入排序、选择排序
 */
public class Sorts {
    
    /**
     * 冒泡排序
     * 原地排序 ： 是
     * 是否稳定 ： 是
     * 空间复杂度：o(1)
     * 最好情况时间复杂度：o(n)
     * 最快情况时间复杂度：o(n方)
     *
     * @param nums 数组
     * @param n    数组长度
     */
    public static void bubbleSort(int[] nums, int n) {
        if (n <= 1) {
            return;
        }
        for (int j = 0; j < n - 1; j++) {
            //标识是否提前推出
            boolean flag = false;
            for (int i = 0; i < n - 1 - j; i++) {
                if (nums[i] > nums[i + 1]) {
                    int tem = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = tem;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
    }
    
    /**
     * 冒泡排序改进:在每一轮排序后记录最后一次元素交换的位置,作为下次比较的边界,
     * 对于边界外的元素在下次循环中无需比较.
     * 原地排序 ： 是
     * 是否稳定 ： 是
     * 空间复杂度：o(1)
     * 最好情况时间复杂度：o(n)
     * 最快情况时间复杂度：o(n方)
     *
     * @param nums 数组
     * @param n    数组长度
     */
    public static void bubbleSort2(int[] nums, int n) {
        if (n <= 1) {
            return;
        }
        int lastExchange = 0;
        int sortedBorder = n - 1;
        for (int j = 0; j < n - 1; j++) {
            //标识是否提前退出
            boolean flag = false;
            for (int i = 0; i < sortedBorder; i++) {
                if (nums[i] > nums[i + 1]) {
                    int tem = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = tem;
                    lastExchange = i;
                    flag = true;
                }
            }
            sortedBorder = lastExchange;
            if (!flag) {
                break;
            }
        }
    }
    
    /**
     * http://notepad.yehyeh.net/Content/Algorithm/Sort/Insertion/1.php
     * 插入排序
     * 原地排序 ： 是
     * 是否稳定 ： 是
     * 空间复杂度：o(1)
     * 最好情况时间复杂度：o(n)
     * 最坏情况时间复杂度：o(n方)
     *
     * @param nums 数组
     * @param n    数组长度
     */
    public static void insertSort(int[] nums, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int value = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > value) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = value;
        }
    }
    
    /**
     * 选择排序
     * 原地排序 ： 是
     * 是否稳定 ： 是
     * 空间复杂度：o(1)
     * 最好情况时间复杂度：o(n)
     * 最坏情况时间复杂度：o(n方)
     *
     * @param nums 数组
     * @param n    数组长度
     */
    public static void selectionSort(int[] nums, int n) {
        if (n <= 1) {
            return;
        }
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            //交换
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }
    
    public static void printAll(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
    
    
    public static void main(String[] args) {
        int nums[] = {3, 1, 5, 4, 2};
//        bubbleSort(nums, 5);
//        bubbleSort2(nums, 5);
//        insertSort(nums, 5);
//        selectionSort(nums, 5);
        printAll(nums);
    }
}
