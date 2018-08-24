package letcode;

import arithmetic.Factor;

import java.util.Arrays;

/**
 *  * 二维数组
 *      对象线遍历
 *      https://leetcode-cn.com/submissions/detail/5938796/
 *  *
 *  * @author xiaoqi
 *  * @since 22 八月 2018
 *  
 */
public class TwoDimensionalArrayTest {

    public static void printArray (int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; array[i] != null && j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main (String[] args) {
        int[][] array = new int[2][5];
        printArray(array);

        int[][] b = new int[2][];
        printArray(b);

        b[0] = new int[3];
        b[1] = new int[5];
        printArray(b);

        int[][] array1 = new int[][]{{1},{2},{3},{4},{5},{6},{7},{8},{9},{10}};
        int[] array2 = findDiagonalOrder(array1);
        System.out.println("hhh");
        Arrays.stream(array2).forEach(i -> System.out.println(i));
    }

    public static int[] findDiagonalOrder (int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }
        int[] array = new int[matrix.length * matrix[0].length];
        int i = 0;
        int j = 0;
        int num = 0;
        //array[0] = matrix[0][0];
        //true 向上遍历，false 向下遍历
        boolean flag = true;
        while (i <= matrix.length - 1 && j <= matrix[0].length - 1) {
            array[num] = matrix[i][j];
            num++;
            if (i == 0) {
                if (j % 2 == 0) {
                    //向上到达边界，回笼
                    if (j + 1 > matrix[0].length - 1) {
                        j = matrix[0].length - 1;
                        i = i + 1;
                        flag = false;
                        continue;
                    } else {
                        j = j + 1;
                    }
                    flag = true;
                    continue;
                } else {
                    //向下无路可走
                    if (i + 1 > matrix.length - 1) {
                        i = matrix.length - 1;
                        j = j + 1;
                        flag = true;
                        continue;
                    } else {
                        i = i + 1;
                        j = j - 1;
                    }
                    flag = false;
                    continue;
                }
            }
            if (j == 0) {
                if (i % 2 == 0) {
                    //向上到达边界，回笼
                    if (j + 1 > matrix[0].length - 1) {
                        i = i + 1;
                        flag = false;
                        continue;
                    }
                    i = i - 1;
                    j = j + 1;
                    flag = true;
                    continue;
                } else {
                    //到达边界，回笼
                    if (i + 1 > matrix.length - 1) {
                        j = j + 1;
                    } else {
                        i = i + 1;
                    }
                    flag = true;
                    continue;
                }
            }
            //产生下一个数坐标
            if (flag) {
                //到达边界，回笼
                if (j + 1 > matrix[0].length - 1) {
                    i = i + 1;
                    flag = !flag;
                } else {
                    i = i - 1;
                    j = j + 1;
                }
                continue;
            } else {
                //到达边界,回笼
                if (i + 1 > matrix.length - 1) {
                    j = j + 1;
                    flag = !flag;
                } else {
                    i = i + 1;
                    j = j - 1;
                }
                continue;

            }
        }
        return array;
    }
}
