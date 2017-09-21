package java8feature;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AppplesFilter {

    public static void main (String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        // java8 利用 Predicate来传递代码
//        List<Apple> greenApples = filterApples(inventory, AppplesFilter::isGreenApple);
//        System.out.println(greenApples);
//
//        List<Apple> heavyApples = filterApples(inventory, AppplesFilter::isHeavyApple);
//        System.out.println(heavyApples);

        //从传递方法到 Lambda
        // 把方法作为值来传递显然很有用，但要是为类似于isHeavyApple 和 isGreenAplle这种可能只用一两次的短方法
        //写一堆定义有点儿烦人。 Java8也解决了这个问题，它引入了一个新的记法（匿名函数或Lambda）
//        List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
//        System.out.println(greenApples2);
//
//        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
//        System.out.println(heavyApples2);
//
//        List<Apple> weirdApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80 ||
//                "brown".equals(a.getColor()));
//        System.out.println(weirdApples);

        //利用Stream 和 Lambda 表达式顺序地或并行地从一个列表里筛选比较重的苹果。
        //Collection主要是为了存储和访问数据，而Stream则主要用于描述对数据的计算。
        //顺序处理
        List<Apple> heavyApples3 = inventory.stream().filter((Apple a) -> a.getWeight() > 150)
                .collect(Collectors.toList());
        System.out.println(heavyApples3);

        //并行处理
        List<Apple> heavyApples4 = inventory.parallelStream()
                .filter((Apple a) -> a.getWeight() > 150)
                .collect(Collectors.toList());
        System.out.println(heavyApples4);

        //农民要求筛选青苹果
        List<Apple> greenApples3 = filterGreenApples(inventory);
        System.out.println(greenApples3);

        //农民要求筛选多种颜色的苹果： 青苹果、红苹果、。。。。。
        List<Apple> greenApples4 = filterApplesByColor(inventory, "green");
        List<Apple> redApples = filterApplesByColor(inventory, "red");
        List<Apple> blueApples = filterApplesByColor(inventory, "blue");

        //第三次抽象：对你能想到的农民的需求抽象： 对每个属性做筛选
        List<Apple> greenApples5 = filterApples(inventory, "green", 0, true);
        System.out.println(greenApples5);

        List<Apple> heavyApples5 = filterApples(inventory, "", 150, false);
        System.out.println(heavyApples5);

        //第四次尝试：根据抽象条件筛选
        List<Apple> heavyApples6 = filterApples(inventory, new AppleHeavyWeithPredicate());
        System.out.println(heavyApples6);

        //打印分钟复合符合条件的苹果
        printApples(inventory, new PrintGrrenApple());
        printApples(inventory, new PrintGrrenApple());

        printPrettyApples(inventory, new AppleFancyFormat());
        printPrettyApples(inventory, new AppleSimpleFormat());

        //创建一个匿名类实现ApplePredicate,直接内联参数化filterApple方法的行为
        List<Apple> redApples1 = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test (Apple apple) {
                return "red".equals(apple.getColor());
            }
        });
        System.out.println(redApples1);

        //第六次尝试：使用lambda表达式
//        List<Apple> result = filterApples(inventory, (Apple apple ) -> "red".equals(apple.getColor()) );
//        System.out.println(result);

        //农民与要求按苹果的重量排序----创建Comparator匿名内部类的方式
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare (Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        System.out.println(inventory);

        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(inventory);
    }

    public static boolean isGreenApple (Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple (Apple apple) {
        return apple.getWeight() > 150;
    }

    //筛选绿苹果
    public static List<Apple> filterGreenApples (List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    //筛选有颜色苹果的进化版
    public static List<Apple> filterApplesByColor (List<Apple> inventory,
                                                   String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return null;
    }

    //农民要求筛选出重量大于150克的苹果
    public static List<Apple> filterApplesByWeight (List<Apple> inventory,
                                                    int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    //第三次尝试，对你能想到的每个属性做筛选
    public static List<Apple> filterApples(List<Apple> inventory, String color,
                                           int weight, boolean flag) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if ((flag && apple.getColor().equals(color)) ||
                    (!flag && apple.getWeight() > weight)) {
                result.add(apple);
            }
        }
        return result;
    }

    //第四次尝试，根据抽象条件筛选，把筛选苹果的方式进行建模，利用策略设计模式
    //对筛选条件进行抽象
    public static List<Apple> filterApples(List<Apple> inventory,
                                           ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory ) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void printPrettyApples(List<Apple> inventory,
                                         AppleFormat appleFormat) {
        for (Apple apple : inventory) {
            String output = appleFormat.accept(apple);
            System.out.println(output);
        }
    }

    public static void printApples (List<Apple> inventory,
                                    PrintApplePredicate p) {
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                System.out.print(apple);
            }
        }
        System.out.println();
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    public static List<Apple> filterHeavyApples (List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            result.add(apple);
        }
        return result;
    }

    // Java8 会把条件代码作为参数传递进去，这样可以避免filter方法出现重复的代码；
    public static List<Apple> filterApples (List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static class Apple {
        private Integer weight = 0;
        private String color = "";

        public Apple (Integer weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public Integer getWeight () {
            return weight;
        }

        public void setWeight (Integer weight) {
            this.weight = weight;
        }

        public String getColor () {
            return color;
        }

        public void setColor (String color) {
            this.color = color;
        }

        @Override
        public String toString () {
            return "Apple{" +
                    "weight=" + weight +
                    ", color='" + color + '\'' +
                    '}';
        }

    }
}
