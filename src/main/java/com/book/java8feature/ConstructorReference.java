package com.book.java8feature;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *  构造函数引用
 *      对于一个现有构造函数，你可以利用它的名称 和关键字 new 来创建它的一个引用：
 *   ClassName::new.它的功能与指向静态方法的引用类似。
 */
public class ConstructorReference {

    static Map<String, Function<Integer, Fruit>> map = new HashMap<>();

    static {
        map.put("apple", Apple::new);
        map.put("orange", Orange::new);
    }

    public static void main (String[] args) {
        //假设你有一个构造函数没有参数。它适合Supplier的签名 () -> Apple.
        Supplier<Apple> c1 = Apple::new;
        Apple a1= c1.get();
        //等价于
        Supplier<Apple> c2 = () -> new Apple();
        Apple a2 = c2.get();

        //如果你有你的构造函数的签名是  Apple(Integer weight),那么它就适合Function接口的签名，于是，你可以这样写：
        Function<Integer,Apple> c3 = Apple::new;
        Apple a3 = c3.apply(100);
        //等价于
        Function<Integer, Apple> c4 = (weight) -> new Apple(weight);
        Apple a4 = c4.apply(100);

        //在下面的代码中，一个由Integer 构成的List中的每个元素都通过我们前面定义的类似的map方法传递给了Apple
        //的构造函数，得到一个具有不同重量的List
        List<Integer> weights = Arrays.asList(7, 3, 4, 10);
        List<Apple> apples = map(weights, Apple::new);
        System.out.println(apples);

        //如果你有一个具有两个参数的构造函数Apple(String color, Integer weight),那么它就适合BiFunction接口
        //的签名
        BiFunction<Integer, String, Apple> c5 = Apple::new;
        Apple a5 = c5.apply(100, "green");
        System.out.println(a5);

        System.out.println(giveMeFruit("apple",100));
        System.out.println(giveMeFruit("orange", 120));
    }

    public static List<Apple> map(List<Integer> list,
                                  Function<Integer, Apple> function) {
        List<Apple> result = new ArrayList<>();
        for (Integer i : list) {
            result.add(function.apply(i));
        }
        return result;
    }

    /**
     * 不将构造函数实例化却能引用它，这个功能有一些有趣的应用。
     *   例如： 可以利用Map来将构造函数映射到字符串值。可以创建一个giveMeFruit方法，给它一个String 和一个Integer,
     *   它就可以创建出不同重量的各种水果。
     * @param fruit
     * @param weight
     * @return
     */
    public static Fruit giveMeFruit(String fruit, Integer weight) {

        return map.get(fruit.toLowerCase())
                .apply(weight);
    }
}
