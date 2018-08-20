package letcode;


import java.util.ArrayList;
import java.util.Arrays;

/**
 *  * 给定一个非负整数组成的非空数组，在该数的基础上加一，返回一个新的数组。

 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

 你可以假设除了整数 0 之外，这个整数不会以零开头。

 示例 1:

 输入: [1,2,3]
 输出: [1,2,4]
 解释: 输入数组表示数字 123。
 示例 2:

 输入: [4,3,2,1]
 输出: [4,3,2,2]
 解释: 输入数组表示数字 4321。
 *  *
 *  * @author xiaoqi
 *  * @since 20 八月 2018
 *  
 */
class Solution {

    /**
     * 解法1。遇见int ,long 的最大值无法计算
     *      例如： [9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9]
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        int [] result = new int [digits.length];

        long num = 0;
        int i = 0;
        //计算这个整数
        while(i < digits.length) {
            int k = digits.length -1;
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
        int m = digits.length -1;
        while(l < digits.length) {
            long n = 1;
            while(m > 0) {
                n *= 10;
                m--;
            }
            result[l] = (int) (num / n);
            num -= result[l] * n;
            l++;
        }

        return result;
    }

    public static void main (String[] args) {
        System.out.println(new ArrayList<>(Arrays.asList(plusOne(new int [] {7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6}))));
    }
}