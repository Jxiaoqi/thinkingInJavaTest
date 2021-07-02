package com.book.algo.sort2;

import java.util.Arrays;
import java.util.concurrent.locks.ReentrantLock;

public class QuickSortTest {
    
    public static void main(String[] args) {
        int[] nums = {3, 5, 4, 1, 2};
        quickSort(nums, 0, 4);
        Arrays.stream(nums).forEach(i -> System.out.print(i + " "));
    }
    
    public static void quickSort(int[] nums, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(nums, p, r);
        quickSort(nums, p, q -1);
        quickSort(nums, q + 1, r);
    }

    public static int partition(int[] nums, int p, int r) {
        int pivot = nums[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (nums[j] < pivot) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i = i + 1;
            }
        }
        int temp = nums[i];
        nums[r] = temp;
        nums[i] = pivot;
        return i;
    }
}
