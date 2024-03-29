package arithmetic.leetcode;

import com.google.common.collect.Lists;
import org.apache.poi.ss.formula.udf.IndexedUDFFinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 寻找数组中的中心元素 https://leetcode-cn.com/explore/learn/card/array-and-string/198/introduction-to-array/770/
 *
 * @author xiaoqi
 * @since 27 九月 2018
 */
public class PivotIndex {
    
    /**
     * 每次计算元素i 左边的总和，右边的总是= 全部元素总和 - 左边 - i 超时
     *
     * @param nums
     * @return
     */
    public static int pivotIndex(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int sum = list.stream().reduce(0, Integer::sum);
        for (int i = 0; i < nums.length; i++) {
            int left = list.subList(0, i).stream().reduce(0, Integer::sum);
            int right = sum - left - list.get(i);
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * 基于右边元素的和 = 总和 - 左边元素的和，新开辟一个数组，记录 i 位置的左边元素的和，然后遍历该数组，得到中间下标
     *
     * @param nums
     * @return
     */
    public static int pivotIndexPlus(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        if (len == 1) {
            return 0;
        }
        int sum = 0;
        int[] sums = new int[len];
        sums[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
            sum = sum + nums[i];
        }
        for (int i = 0; i < len; i++) {
            int left = sums[i];
            int right = sum - sums[i] - nums[i];
            if (left == right) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(pivotIndexPlus(nums));
    }
}
