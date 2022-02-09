package com.book.java8feature;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * 2.3 方法引用
 方法引用提供了非常有用的语法，可以直接引用已有Java类或对象（实例）的方法或构造器。
 与lambda联合使用，方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
 */
@Data
public class Car {

    private String year;

    private String machine;

    public static Car create(final Supplier<Car> supplier) {
        return  supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("collide " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repire() {
        System.out.println("Repaired " + this.toString());
    }

    public static void main(String[] args) {
        //第一种方法引用是构造器引用，它的语法是Class::new，或者更一般的Class< T >::new。请注意构造器没有参数
        final Car car = Car.create(Car::new);
        final List<Car> cars = Arrays.asList(car);

        //第二种方法引用是静态方法引用，它的语法是Class::static_method。请注意这个方法接受一个Car类型的参数。
        cars.forEach(Car::collide);
        //第三种方法引用是特定类的任意对象的方法引用，它的语法是Class::method。请注意，这个方法没有参数。
        cars.forEach(Car::repire);
        //第四种方法引用是特定对象的方法引用，它的语法是instance::method。请注意，这个方法接受一个Car类型的参数
        final Car police = Car.create(Car::new);
        cars.forEach(police::follow);

        /**
         * collide com.book.java8feature.Car@27d6c5e0
         Repaired com.book.java8feature.Car@27d6c5e0
         Following the com.book.java8feature.Car@27d6c5e0
         */

        List<Car> cars1 = Lists.newArrayList();
        Map<String, Map<String, List<Car>>> map =
                cars1.stream().collect(Collectors.groupingBy(Car::getYear, Collectors.groupingBy(Car::getMachine)));

    }
}
