package com.book.algo.sort2;

public class QuickSort {
    
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }
    
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(a, p, r);
        quickSortInternally(a, p, q - 1);
        quickSortInternally(a, q + 1, r);
    }
    
    
    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r - 1; j++) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }
        int tmp = a[r];
        a[r] = a[i];
        a[i] = tmp;
        System.out.println("i= " + i);
        return i;
    }
    
    public static void printAll(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int nums[] = {5, 7, 3, 8, 1};
        quickSort(nums, 5);
        printAll(nums);
    }
}
