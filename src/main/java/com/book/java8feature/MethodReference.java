package com.book.java8feature;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 *  方法引用
 *      方法引用让你可以重复使用现有的方法定义，并像lambda一样传递它们。
 *      Apple :: getWeight就是引用了Apple类中定义的方法getWeight.方法引用就是
 *   lambda表达式 (Apple a) -> a.getWeight() 的快捷写法。
 */
public class MethodReference {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(150, "green"),
                                              new Apple(160, "red"),
                                              new Apple(120, "green"),
                                              new Apple(130, "red"));
        inventory.sort((Apple a1, Apple a2)
                -> a1.getWeight().compareTo(a2.getWeight()));
        System.out.println(inventory);

        inventory.sort(Comparator.comparing(Apple :: getWeight));
        System.out.println(inventory);

        //Lambda及其等效的方法引用的例子
//        (Apple a) -> a.getWeight()  对应  Apple::getWeight
//        () -> Thread.currentThread().dumpStack();     对应： Thread.currentThread()::dumStack
//        (str, i) -> str.substring(i)  对应  String::substring
//        (String s) -> System.out.println(s)  对应 System.out::println

        List<String> str = Arrays.asList("a", "b", "A", "B");
        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        System.out.println(str);
        //转换成对应的方法引用
        str.sort(String::compareToIgnoreCase);
        System.out.println(str);

        Function<String, Integer> stringToInteger =
                (String s) -> Integer.parseInt(s);
        //转换成对应的方法引用
        Function<String, Integer> stringToInteger1 = Integer::parseInt;
        System.out.println(stringToInteger.equals(stringToInteger1));

        BiPredicate<List<String>, String> constains =
                (list, element) -> list.contains(element) ;
        //转换成对应的方法引用
        //这是因为，目标类型描述的函数描述符是(List<String>, String) -> boolean,
        //而 List:contains可以被解包成这个函数描述符
        BiPredicate<List<String>, String> contains = List::contains;
    }

}
