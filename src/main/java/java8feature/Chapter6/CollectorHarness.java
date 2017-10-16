package java8feature.Chapter6;

/**
 *  * 比较收集器的性能
 *  * @author xiaoqi
 *  * @since 16 十月 2017
 *  
 */
public class CollectorHarness {

    public static void main (String[] args) {
        long fastest = Long.MAX_VALUE;
        //计算原方法的执行时间
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();     //微秒
            PartitionTest.partitionPrimes(100000);
            long end = System.nanoTime();
            long duration = (end - start)/1000000;
            if (duration < fastest) {
                fastest = duration;
            }
        }
        System.out.println("Fastest execulation done in " + fastest + "msecs");
    }

}
