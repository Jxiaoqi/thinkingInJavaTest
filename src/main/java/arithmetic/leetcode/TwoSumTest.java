package arithmetic.leetcode;

/**
 * 两数相加 Two Sum Given an array of integers, return indices of the two numbers such that they add up
 * to a specific target. You may assume that each input would have exactly one solution. Example:
 * Given nums = [2, 7, 11, 15], target = 9, Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 * 翻译: 两数之和 给定一个整形数组和一个整数target，返回2个元素的下标，它们满足相加的和为target。 你可以假定每个输入，都会恰好有一个满足条件的返回结果,也就是多种答案的情况不予考虑
 * 例如给定了数组 nums = [2, 7, 11, 15], 需要的target = 9, 因为 nums[0] + nums[1] = 2 + 7 = 9, 所以返回 [0, 1]
 * 
 * @author xiaoqi
 *
 */
public class TwoSumTest {

    public static void main(String[] args) {
        int source[] = {1, 3, 5, 7, 9};
        int index[] = twoSum(source, 10);
        System.out.println("和为 10的两个下标为： ");
        for (int i = 0; i < index.length; i++) {
            System.out.print(index[i] + ", ");
        }
    }

    /**
     * 暴力解法，时间复杂度 O（n*n）
     * 
     * @param source
     * @param target
     * @return
     */
    public static int[] twoSum(int[] source, int target) {

        if (source == null) {
            return new int[] {-1, -1};
        }

        for (int i = 0; i < source.length; i++) {
            for (int j = i + 1; j < source.length; j++) {
                if (source[i] + source[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }

}
