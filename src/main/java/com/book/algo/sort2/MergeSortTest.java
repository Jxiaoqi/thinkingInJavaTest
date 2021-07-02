package com.book.algo.sort2;

import java.util.Arrays;

public class MergeSortTest {
    
    public static void main(String[] args) {
        int[] nums = {3, 5, 4, 1, 2};
        mergeSort(nums, 0, 4);
        Arrays.stream(nums).forEach(i -> System.out.print(i + " "));
    }
    
    public static void mergeSort(int[] nums, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = p + (r - p) / 2;
        mergeSort(nums, p, q);
        mergeSort(nums, q + 1, r);
//        merge(nums, p, q, r);
        mergeWithS(nums, p, q , r);
    }
    
    public static void mergeWithS(int[] nums, int p, int q, int r) {
        
        int p1 = p;
        int q1 = q;
        int[] leftTemp = new int[q - p + 2];
        int[] rightTemp = new int[r - q + 1];
        int left = 0;
        while (p1 <= q) {
            leftTemp[left++] = nums[p1++];
        }
        leftTemp[left] = Integer.MAX_VALUE;
    
        int right = 0;
        q1 = q1 + 1;
        while (q1 <= r) {
            rightTemp[right++] = nums[q1++];
        }
        rightTemp[right] = Integer.MAX_VALUE;
        
        left = 0 ;
        right = 0;
        while (p <= r) {
            if (leftTemp[left] >= rightTemp[right]) {
                nums[p++] = rightTemp[right++];
            } else {
                nums[p++] = leftTemp[left++];
            }
        }
    }
    
    public static void merge(int[] nums, int p, int q, int r) {
        int[] temp = new int[r - p + 1];
        int index = 0;
        int left = p;
        int right = q + 1;
        while (left <= q && right <= r) {
            if (nums[left] >= nums[right]) {
                temp[index++] = nums[right++];
            } else {
                temp[index++] = nums[left++];
            }
        }
        // 判断哪个子数组中有剩余的数据
        int start = left;
        int end = q;
        if (right <= r) {
            start = right;
            end = r;
        }
        
        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            temp[index++] = nums[start++];
        }
        
        //合并
        for (int i = 0; i < temp.length; i++) {
            nums[p + i] = temp[i];
        }
    }
}
