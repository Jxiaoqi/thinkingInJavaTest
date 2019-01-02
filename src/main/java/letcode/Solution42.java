package letcode;


import com.google.common.base.Stopwatch;

import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *  * TODO completion javadoc.
 *  *
 *  * @author xiaoqi
 *  * @since 25 八月 2018
 *  
 */
public class Solution42 {

    /**
     * 逐渐升高地平线计数
     *
     * @param height
     * @return
     */
    public static int trap (int[] height) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        stopwatch.start();
        if (height.length == 0) {
            return 0;
        }

        List<Integer> heights = Arrays.stream(height).boxed().collect(Collectors.toList());
        int max = heights.stream().max(Integer::compareTo).get();
        int count = 0;
        for (int i = 1; i <= max; i++) {
            //开始计数
            boolean flag = false;
            for (int j = 0; j < heights.size() - 1; j++) {
                if (heights.get(j).compareTo(i) >= 0) {
                    flag = true;
                    continue;
                }
                if (flag && heights.get(j).compareTo(i) < 0) {
                    //寻找以下高度是否有和它一样高的
                    Integer nextMax = heights.subList(j, heights.size()).stream().max(Integer::compareTo).orElse(0);
                    if (nextMax > 0 && nextMax.compareTo(i) >= 0) {
                        count++;
                        continue;
                    } else {
                        break;
                    }
                }
            }
        }
        stopwatch.stop();
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS) + " ms");
        return count;
    }

    /**
     * @param height
     * @return
     */
    public static int trap1 (int[] height) {
        if (height.length == 0) {
            return 0;
        }
        List<Integer> heights = Arrays.stream(height).boxed().collect(Collectors.toList());
        int count = 0;
        //当前比较基准
        int temp = heights.get(0);
        for (int i = 1; i < heights.size(); i++) {
            int nowH = heights.get(i);
            Integer nextMax = heights.subList(i, heights.size()).stream().max(Integer::compareTo).orElse(0);
            //出现低位，则判断是否可以计数
            if (temp > nextMax) {
                temp = nextMax;
            }
            if (nowH < temp) {
                if (nextMax.compareTo(nowH) >= 0) {
                    count = count + temp - nowH;
                } else {
                    temp = nextMax;
                    continue;
                }
            } else {
                temp = nowH;
                continue;
            }
        }
        return count;
    }

    /**
     * 思路： 某一个位置的水流不出来
     *
     * @param height
     * @return
     */
    public static int trap2 (int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int result = 0;
        List<Integer> heights = Arrays.stream(height).boxed().collect(Collectors.toList());
        for (int i = 1; i < heights.size() - 1; i++) {
            //找左边的最大值
            int lMax = heights.subList(0, i).stream().max(Integer::compareTo).orElse(0);
            //找右边最大值
            int rMax = heights.subList(i + 1, heights.size()).stream().max(Integer::compareTo).orElse(0);
            int min = Math.min(lMax, rMax);
            if (min > heights.get(i)) {
                result = result + min - heights.get(i);
            }

        }
        return result;
    }

    public static void main (String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int count = trap2(height);
        System.out.println(count);
    }
}
