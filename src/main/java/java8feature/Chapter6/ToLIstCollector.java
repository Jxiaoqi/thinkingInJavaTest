package java8feature.Chapter6;

import java8feature.Chapter4.Dish;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *  * 收集器接口 6.5
 *     开发自己的ToListCollector
 *  * @author xiaoqi
 *  * @since 13 十月 2017
 *  
 */
public class ToLIstCollector<T> implements Collector<T, List<T>, List<T>> {

    @Override
    public Supplier<List<T>> supplier () {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<T>, T> accumulator () {
        return List::add;
    }

    @Override
    public BinaryOperator<List<T>> combiner () {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    @Override
    public Function<List<T>, List<T>> finisher () {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics () {
        return Collections.unmodifiableSet(EnumSet.of(
                Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT
        ));
    }

    public static void main (String[] args) {
        List<Dish> menu = Dish.menu;
        // 自定义的#ToListCollector可以完全替代原生Java的 #Collectors.toList(),构造之间的
        //其他差异在于toList是一个工厂，而ToListCollector必须用 new 来实例化。
        List<Dish> dishes = menu.stream().collect(new ToLIstCollector<>());
        System.out.println(dishes);

        /**
         * Stream有一个重载的collect方法可以接受另外三个函数 supplier、accumulator、combiner
         * 其语义和Collector接口的相应方法返回的函数完全相同。
         *      该collect方法不接受传递任何characteristics，所以它永远是IDENTITY_FISH和 CONCURRENT
         * 但并非UNORDERED
         */
        List<Dish> dishes1 = menu.stream().collect(
                                    ArrayList::new,
                                    List::add,
                                    List::addAll
        );
        System.out.println(dishes1);
    }

}
