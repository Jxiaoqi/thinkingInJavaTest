package letcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。
 * <p>
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 * <p>
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 * <p>
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *  *
 *  * @author xiaoqi
 *  * @since 20 八月 2018
 *  
 */
class Solution {

    /**
     * 解法1。遇见int ,long 的最大值无法计算
     * 例如： [9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9]
     *
     * @param digits
     * @return
     */
    public static int[] plusOne (int[] digits) {
        int[] result = new int[digits.length];

        long num = 0;
        int i = 0;
        //计算这个整数
        while (i < digits.length) {
            int k = digits.length - 1;
            long j = 1;
            while (k > 0) {
                j *= 10;
                k--;
            }
            num += digits[i] * j;
            i++;
        }

        num += 1;
        //拆解这个整数
        int l = 0;
        int m = digits.length - 1;
        while (l < digits.length) {
            long n = 1;
            while (m > 0) {
                n *= 10;
                m--;
            }
            result[l] = (int) (num / n);
            num -= result[l] * n;
            l++;
        }

        return result;
    }

    /**
     * 思路： 塔米诺骨牌，只有以9结尾才会触发连续反应
     *
     * @param digits
     * @return
     */
    public static int[] plusOne2 (int[] digits) {
        digits[digits.length - 1] = digits[digits.length - 1] + 1;
        int[] result = new int[digits.length];
        int[] temp = new int[digits.length];
        //数组的下标
        int i = digits.length - 1;
        //用来标记当前元素，看是否需要逢十进一
        int previous = digits[digits.length - 1];
        while (i >= 0) {
            //逢十，那么让下一个位进1，该位为0
            if (previous > 9) {
                temp[i] = 0;
                if (i > 1) {
                    previous = digits[i - 1] + 1;
                }
            } else {
                //不需要进位，就搬过来
                temp[i] = previous;
            }
            i--;
        }

        //第一位为10的话，就需要扩容了
        if (previous == 10) {
            result = new int[temp.length + 1];
            result[0] = 1;
            //扩容
            System.arraycopy(temp, 0, result, 1, temp.length);
        } else {
            result = temp;
        }
        for (int a : result) {
            System.out.print(a);
        }
        return result;
    }

    /**
     * 塔米诺骨牌，从最后一位开始进位，直到不再进位停止
     * @param digits
     * @return
     */
    public static int[] plusOne3(int[] digits) {
        int len = digits.length;
        for (int i = len -1; i > -1; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        int[] array = new int[digits.length + 1];
        array[0] = 1;
        return array;
    }


    public static void main (String[] args) {
        System.out.println(new ArrayList<>(Arrays.asList(plusOne2(new int[]{9}))));
    }
}