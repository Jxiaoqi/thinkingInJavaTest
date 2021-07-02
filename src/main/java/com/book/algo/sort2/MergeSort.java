package com.book.algo.sort2;

public class MergeSort {
    
    public static void mergeSort(int[] nums, int n) {
        mergeSortInternally(nums, 0, n - 1);
    }
    
    private static void mergeSortInternally(int[] nums, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = p + (r - p) / 2;
        mergeSortInternally(nums, p, q);
        mergeSortInternally(nums, q + 1, r);
//        merge(nums, p, q, r);
        mergeBySentry(nums, p, q, r);
    }
    
    private static void merge(int[] nums, int p, int q, int r) {
        //定义三个指针，讲数组nums[p...q], nums[q+1....r]，合并到 tmp[0...k]中
        int i = p;
        int j = q + 1;
        int k = 0;
        int[] tmp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (nums[i] <= nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        
        //合并剩余数组部分
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end)  {
            tmp[k++] = nums[start++];
        }
        
        //将tmp[0....k]合并到nums[p....r]中
        int index = 0;
        while (p <= r) {
            nums[p++] = tmp[index++];
        }
    }
    
    private static void mergeBySentry(int[] arr, int p, int q, int r) {
        int[] leftArr = new int[q - p + 2];
        //r - (q + 1) + 1  + 1
        int[] rightArr = new int[r - q + 1];

        for (int i = 0; i <= q - p; i++) {
            leftArr[i] = arr[p + i];
        }
        leftArr[q - p + 1] = Integer.MAX_VALUE;

        for (int i = 0; i < r - q; i++) {
            rightArr[i] = arr[q + 1 + i];
        }
        rightArr[r - q] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = p;
        while (k <= r) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

    }
    
    
    public static void printAll(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int nums[] = {5, 7, 3, 8, 1};
        mergeSort(nums, 5);
        printAll(nums);
    }
}
