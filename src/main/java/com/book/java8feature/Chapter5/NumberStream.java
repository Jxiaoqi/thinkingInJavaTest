package com.book.java8feature.Chapter5;

import com.book.java8feature.Chapter4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 数值流
 */
public class NumberStream {

    public static void main (String[] args) {
        List<Dish> menu = Dish.menu;

        //利用reduce方法计算菜单的热量，该段代码的问题： 有一个暗含的装箱成本。每个
        //每个Integer 都必须拆箱成一个原始类型，再进行求和。但是，Stram<T> 没有sum方法
        int calories = menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println(calories);

//原始类型流特化
        //MapToInt()-->IntStream<T>
        int calories1 = menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println(calories1);

        //特化流--》 对象流
        IntStream intStream = menu.stream()
                .mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();

        //OptionalInt 求最大最小值时，为了区分最大值0 和 没有元素，引入了OptionalInt
        OptionalInt maxCalories = menu.stream()
                .mapToInt(Dish::getCalories)
                .max();
        System.out.println(maxCalories);
        //如果没有默认值，显式提供一个最大值
        int max = maxCalories.orElse(1);
        System.out.println(max);

//数值范围
        //IntStream 的静态方法 rangeClosed 和 range()方法
        IntStream evenNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers.count());

        IntStream evenNumbers1 = IntStream.range(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(evenNumbers1.count());

//勾股数
        //生成勾股数
        Stream<int []> pythagoreanTriples =
                IntStream.rangeClosed(1, 100).boxed()
                    .flatMap(a -> IntStream.rangeClosed(a, 100)
                            .filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
                            .mapToObj(b ->
                                new int[]{a, b , (int) Math.sqrt(a*a + b*b)})
                    );
        pythagoreanTriples.forEach(obj -> {
            Arrays.stream(obj)
                .forEach(a -> System.out.print(a + " "));
            System.out.println();
            }
        );

        //优化
        Stream<double[]> pythagoreanTriples1 =
                IntStream.rangeClosed(1, 100).boxed()
                    .flatMap(a -> IntStream.rangeClosed(a, 100)
                    .mapToObj(b -> new double[]{a, b , Math.sqrt(a*a + b*b)})
                    .filter(t -> t[2] % 1 == 0));
        pythagoreanTriples1.forEach(t ->
                System.out.println(t[0] + " " + t[1] + " " + t[2])
                );



    }
}
