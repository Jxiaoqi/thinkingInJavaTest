package com.book.java8feature.Chapter6;

import com.book.java8feature.Chapter4.Dish;
import com.book.java8feature.Chapter5.TradeMain;
import com.book.java8feature.Chapter5.Transaction;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;


/**
 * 第六章 用流收集数据
 *  收集器简介  Collectors
 */
public class CollectorTest {

    public static void main (String[] args) {

        List<Transaction> transactions = TradeMain.transactions;
        //收集器用作高级规约
        List<Transaction> transactions1 = transactions.stream()
                                            .collect(Collectors.toList());

        List<Dish> menu = Dish.menu;
    //规约和汇总
        //规约
        //数一数菜单里有多少种菜
        long howManyDishes = menu.stream().collect(Collectors.counting());
        System.out.println(howManyDishes);

        long howManyDishes1 = menu.stream().count();
        System.out.println(howManyDishes1);

        //查找流中的最大值和最小值  可以使用两个收集器 Collectors.maxBy,  Collectors.minBy
        //这两个收集器可以接受参数 Comparator
        Comparator<Dish> dishCaloriesComparator =
                Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> mostCalorieDish = menu.stream()
                .collect(Collectors.maxBy(dishCaloriesComparator));
        System.out.println(mostCalorieDish);

        //汇总（求和，求平均数）
        //Collectors.summingInt(), Collectors.summingDouble(), Collectors.summingLong()
        int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
        System.out.println(totalCalories);

        //Collectors.averagingInt()  Collectors.averagingLong() Collectors.averagingDouble()
        double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
        System.out.println(avgCalories);

        //Collectors.summarizingInt(), Collectors.summarizingDouble()汇总，总和，数量，最大最小值
        IntSummaryStatistics menuStatics = menu.stream()
                .collect(summarizingInt(Dish::getCalories));
        System.out.println(menuStatics);

        //连接字符串
        //joining()工厂方法返回的收集器会把流中每一个对象应用toString方法得到的所有字符串连接成一个字符串
        String shortMenu = menu.stream().map(Dish::getName).collect(joining());
        System.out.println(shortMenu);

        //joining()工厂方法有一个重载版本可以接受元素之间的分界符
        String shortMenu1 = menu.stream().map(Dish::getName).collect(joining(", "));
        System.out.println(shortMenu1);

//广义的规约汇总
        //所有的收集器，都是一个可以用reducing工厂方法定义的一个规约过程的特殊情况而已
        //Collectors.reducing()需要三个参数： 起始值，转换函数， BinaryOperator(二元操作)
        int totalCalories1 = menu.stream().collect(reducing(
                                0, Dish::getCalories, (i, j) -> i + j));
        System.out.println(totalCalories1);

        //单参数的reducing()工厂方法创建的收集器
        Optional<Dish> mostCalorieDish1 = menu.stream().collect(
                reducing((d1, d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2)
        );
        System.out.println(mostCalorieDish1);

        //收集框架的灵活性：以不同的方法执行同样的操作
        int totalCalories2 = menu.stream().collect(reducing(0,
                                                    Dish::getCalories,
                                                    Integer::sum));
        System.out.println(totalCalories2);
        //不使用收集器使用规约求和
        int totalCalories3 = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
        System.out.println(totalCalories3);

        //IntStream求和,更简明，最易读，同时也是性能最好的一个，因为IntStream避免了自动拆箱操作
        int totalCalories4 = menu.stream().mapToInt(Dish::getCalories).sum();
        System.out.println(totalCalories4);



    }
}
