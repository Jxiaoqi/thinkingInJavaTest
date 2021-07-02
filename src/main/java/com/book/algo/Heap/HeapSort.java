package com.book.algo.Heap;


public class HeapSort {
    
    public static void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        buildHeap(arr);
        int k = arr.length - 1;
        while (k > 0) {
            swap(arr, 1, k);
            k--;
            heapify(arr, k, 1);
        }
    }
    
    
    private static void buildHeap(int[] arr) {
        for (int i = (arr.length - 1) /2; i>=0; i-- ) {
            heapify(arr, arr.length - 1, i);
        }
    }
    
    /**
     * 堆化
     *
     * @param arr 要堆化的数组
     * @param n   最后堆元素下标
     * @param i   要堆化的元素下标
     */
    private static void heapify(int[] arr, int n, int i) {
        while (true) {
            // 最大值位置
            int maxPos = i;
            // 与左子节点（i * 2 + 1）比较，获取最大值位置
            if (i * 2 + 1 <= n && arr[i] < arr[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            // 最大值与右子节点（i * 2 + 2）比较，获取最大值位置
            if (i * 2 + 2 <= n && arr[maxPos] < arr[i * 2 + 2]) {
                maxPos = i * 2 + 2;
            }
            // 最大值是当前位置结束循环
            if (maxPos == i) {
                break;
            }
            // 与子节点交换位置
            swap(arr, i, maxPos);
            // 以交换后子节点位置接着往下查找
            i = maxPos;
        }
    }
    
    private static void swap(int[] a, int m, int n) {
        int tmp = a[m];
        a[m] = a[n];
        a[n] = tmp;
    }
}
