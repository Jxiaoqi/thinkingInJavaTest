package letcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * @author xiaoqi
 * @since 28 九月 2018
 */
public class Solution54 {

    public static List<Integer> spiralOrder (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (j == 0) {
                while (j < matrix[i].length) {
                    list.add(matrix[i][j]);
                    j++;
                }
                continue;
            }
            if (j == matrix[i].length) {
                while (j > 0) {
                    --j;
                    list.add(matrix[i][j]);
                }
                continue;
            }
        }
        return list;
    }

    public static void main (String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));
    }
}
