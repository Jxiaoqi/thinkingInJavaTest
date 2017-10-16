package arithmetic;

import java.util.Arrays;

/**
 * 常用的排序算法
 */
public class SortArithmetic {

    /**
     * 插入排序算法（升序列）
     * 插入排序就是每一步都将一个待排数据按其大小插入到已经排序的数据中的适当位置，直到全部插入完毕。
     * http://www.cnblogs.com/kkun/archive/2011/11/23/2260265.html
     * @param unsorted 待排序数组
     */
    public static void insertion_sort(int[] unsorted) {
        for (int i = 1; i < unsorted.length; i++) {
            int temp = unsorted[i];
            int j = i;
            if (temp < unsorted[j-1]) {
                while (j > 0 && unsorted[j-1] > temp) {
                    unsorted[j] = unsorted[j-1];            //每个数向后移动一位
                    j--;
                }
                unsorted[j] = temp;
            }
        }
        Arrays.stream(unsorted).forEach(System.out::println);
    }

    /**
     * 折半插入排序算法
     * https://baike.baidu.com/item/%E6%8A%98%E5%8D%8A%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F/8208853?fr=aladdin
     * @param unsorted
     */
    public static void binaryInsertion_sort(int[] unsorted) {
        for (int i = 1; i < unsorted.length; i++) {
            //找出待插入该数位置
            int temp = unsorted[i];
            int low = 0;
            int high = i - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (unsorted[mid] < temp) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            //其余后移
            for (int j = i; j >= low + 1; j--) {
                unsorted[j] = unsorted[j-1];
            }
            unsorted[low] = temp;
        }
        Arrays.stream(unsorted).forEach(System.out::println);
    }

    public static void main (String[] args) {
        int[] unsorted = {3, 2, 4, 1, 5};
        binaryInsertion_sort(unsorted);
    }
}
