package com.book.java8feature.Chapter7;

import java.util.stream.Stream;

/**
 *  * 并行流
 *  * @author xiaoqi
 *  * @since 16 十月 2017
 *  
 */
public class ParallelStreamTest {

    /**
     * 一个方法，接受数字N作为参数，并返回从1到给定参数的所有数字的和。
     * @param n
     * @return
     */
    public static long sequentialSum(int n) {
        return Stream.iterate(1L, i -> i + 1)
                     .limit(n)
                     .reduce(0L , Long::sum);
    }

    /**
     * 一个古老的方法，求前n个数字的和
     * @param n
     * @return
     */
    public static long interativeSum(int n) {
        long result = 0;
        for (long i = 0L; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static void main (String[] args) {
        System.out.println(sequentialSum(3));
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
