package java8feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppplesFilter {

    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                                              new Apple(155, "green"),
                                              new Apple(120, "red"));

        // java8 利用 Predicate来传递代码
        List<Apple> greenApples = filterApples(inventory, AppplesFilter::isGreenApple);
        System.out.println(greenApples);

        List<Apple> heavyApples = filterApples(inventory, AppplesFilter::isHeavyApple);
        System.out.println(heavyApples);

        //从传递方法到 Lambda
        // 把方法作为值来传递显然很有用，但要是为类似于isHeavyApple 和 isGreenAplle这种可能只用一两次的短方法
        //写一堆定义有点儿烦人。 Java8也解决了这个问题，它引入了一个新的记法（匿名函数或Lambda）
        List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples2);

        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println(heavyApples2);

        List<Apple> weirdApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80 ||
                                                                        "brown".equals(a.getColor()));
        System.out.println(weirdApples);

        //利用Stream 和 Lambda 表达式顺序地或并行地从一个列表里筛选比较重的苹果。
        //Collection主要是为了存储和访问数据，而Stream则主要用于描述对数据的计算。
        //顺序处理
        List<Apple> heavyApples3 = inventory.stream().filter((Apple a) -> a.getWeight() > 150)
                                            .collect(Collectors.toList());
        System.out.println(heavyApples3);
        //并行处理
        List<Apple> heavyApples4 = inventory.parallelStream().filter((Apple a) -> a.getWeight() > 150 ).collect(Collectors.toList());
        System.out.println(heavyApples4);

    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            result.add(apple);
        }
        return result;
    }

    // Java8 会把条件代码作为参数传递进去，这样可以避免filter方法出现重复的代码；
    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static  class Apple {
        private int weight = 0;
        private String color = "";

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}
