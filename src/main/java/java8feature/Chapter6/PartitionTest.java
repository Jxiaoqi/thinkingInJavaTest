package java8feature.Chapter6;

import java8feature.Chapter4.Dish;

import static java.util.Comparator.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

/**
 *  *6.4 分区
 *  分区是分组的特殊情况： 由一个谓词（返回一个boolean值的函数）作为分类函数，它称为分区函数
 *  返回的Map为 Map<boolean,List<T>>
 *  * @author xiaoqi
 *  * @since 13 十月 2017
 *  
 */
public class PartitionTest {

    public static void main (String[] args) {
        List<Dish> menu = Dish.menu;
        //把菜单中的素食和非素食分开
        Map<Boolean, List<Dish>> partitionedMenu =
                    menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
        System.out.println(partitionedMenu);

        //通过分区后的Map就可以找出所有的素食
        List<Dish> vegetarianDishes = partitionedMenu.get(true);
        System.out.println(vegetarianDishes);
        //方式二
        List<Dish> vegetarianDishes1 =
                    menu.stream().filter(Dish::isVegetarian).collect(Collectors.toList());
        System.out.println(vegetarianDishes1);

        //Collectors.partitioningBy()工厂方法有一个重载版本，可以传递第二个收集器。
        Map<Boolean, Map<Dish.Type, List<Dish>>> vegetarainDishedByType =
                    menu.stream().collect(
                            Collectors.partitioningBy((Dish::isVegetarian),
                                    Collectors.groupingBy(Dish::getType)));
        System.out.println(vegetarainDishedByType);

        //找出素食和非素食中能量最高的菜
        Map<Boolean, Dish> mostCaloricPartitionedByVegetarian =
                    menu.stream().collect(
                            partitioningBy((Dish::isVegetarian),
                                    collectingAndThen(maxBy(comparingInt(Dish::getCalories)),
                                            Optional::get))
                    );
        System.out.println(mostCaloricPartitionedByVegetarian);

        Map<Boolean,List<Integer>> partitionPrimes =
                PrimesCollectors.partitionPrimesWithCustomController(10);
        System.out.println(partitionPrimes);


    }

    /**
     * 筛选出小于等于n 的所有质数
     * @param n
     * @return
     */
    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n)
                        .boxed()
                        .collect(partitioningBy(i -> isPrime(i)));
    }

    /**
     * 判断一个数字是否是质数的谓词
     * @param candidate
     * @return
     */
    public static boolean isPrime(int candidate) {
        return IntStream.range(2, candidate)
                        .noneMatch(n -> candidate % n == 0);
    }

    /**
     * 改进型的判断一个数是否是质数的谓词
     * @param candidate
     * @return
     */
    public boolean isPrime1(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.range(2, candidateRoot)
                        .noneMatch(i -> candidateRoot % i == 0);
    }
}
