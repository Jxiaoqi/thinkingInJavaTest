package com.book.java8feature.Chapter4;

import java.util.List;
import static java.util.stream.Collectors.toList;

/**
 * 流操作--中间操作 4.4
 */
public class StreamOperatorTest {

    public static void main (String[] args) {
        List<Dish> menu = Dish.menu;

        List<String> names =
                menu.stream()
                .filter(dish -> {
                    System.out.println("filtering " + dish.getName());

                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping " + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(toList());

        /**
         * filtering pork
         mapping pork
         filtering beef
         mapping beef
         filtering chicken
         mapping chicken
         */

        /**
         * 终端操作，会从流的流水线生成结果。其结果是任何不是流的值，比如：list,Integer,甚至void.
         * 在下面的流水线中，forEach是一个返回void的终端操作，它会对源中的每道菜应用一个Lambda.
         */
        menu.stream().forEach(System.out :: println);

    }
}
