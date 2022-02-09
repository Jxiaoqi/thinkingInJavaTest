package com.book.java8feature.Chapter5;

import com.book.java8feature.Chapter4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * 5.3 使用流--查找和匹配(短路逻辑)
 *      anyMatch
 *      allMatch
 *      noneMatch
 */
public class FindAndMatch {

    public static void main (String[] args) {

        List<Dish> menu = Dish.menu;

        //anyMatch 流中是否有一个元素能匹配给定的谓词。 看下菜单中是否有素食可供选择。anyMatch返回一个boolean,是一个终端操作
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }

        //检查菜品是否都健康 Stream.allMatch   Stream.noneMatch
        boolean isHealthy = menu.stream()
                .allMatch(dish -> dish.getCalories() < 1000);
        System.out.println(isHealthy);

        boolean isHealthy2 = menu.stream()
                .noneMatch(dish -> dish.getCalories() > 1000);
        System.out.println(isHealthy2);

        //查找元素
        Optional<Dish> dish =
                menu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
        System.out.println(dish);

        //Optional 类的 ifPresent(Consumber<T> block)方法
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(d -> System.out.println(d.getName()));

        //查找第一个元素     给定一个数字列表，找出第一个平方能被3整除的数。
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> firstSquareDivisibleByThree =
                someNumbers.stream()
                .map(x -> x * x)
                .filter(y -> y % 3 == 0)
                .findFirst();
        System.out.println(firstSquareDivisibleByThree);


        List<Integer> numbers = Arrays.asList(3, 2, 5, 9);
//规约
   //reduce 求和
        //T reduce(T identity, BinaryOperator<T> accumulator);
        int num = numbers.stream().reduce(0, (a, b ) -> a + b);
        System.out.println(num);
        //public static int sum(int a, int b)
        int num1 = numbers.stream().reduce(0,Integer::sum);
        System.out.println(num1);

        //Optional<T> reduce(BinaryOperator<T> accumulator);
        Optional<Integer> sum3 = numbers.stream().reduce((a, b) -> a + b);
        System.out.println(sum3);

        //reduce 求最大最小值
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println(max);

        System.out.println("----------");
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        System.out.println(min);

   //map-reduce模式
        int count = menu.stream()
                .map(d -> 1)
                .reduce(0,(a, b) -> a + b);
        System.out.println(count);

        long count2 = menu.stream().count();
        System.out.println(count2);



    }
}
