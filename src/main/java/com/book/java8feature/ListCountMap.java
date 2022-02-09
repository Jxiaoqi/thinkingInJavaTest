package com.book.java8feature;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *  *
 *  *
 *  * @author xiaoqi
 *  * @since 09 十二月 2017
 *  
 */
public class ListCountMap {
    public static void main (String[] args) {
        List<Integer> list = new ArrayList() {
            {
                add(12);
                add(20);
                add(12);
                add(20);
                add(59);
                add(159);
            }
        };

        list.add(2, 13);
        System.out.println(list);
        Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        System.out.println(map);

        Integer a = 14;
        int b = 13;
        System.out.println(a != b);

        long l = 0;
        System.out.println(l == 0);

        int i = 3;
        long l1 = 4;
        System.out.println(i > l1);

        System.out.println("Java".hashCode());
    }
}
