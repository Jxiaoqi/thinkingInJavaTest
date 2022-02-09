package com.book.java8feature;


import java.util.function.Supplier;

/**
 * java函数式编程之Supplier
 */
public class TestSupplier {

    public static void main(String[] args) {
        Supplier<User> supplier = () -> new User();
        User user = supplier.get();
        System.out.println(user.toString());
        System.out.println(supplier.get());

        /**
         * com.book.java8feature.User@16b98e56
           com.book.java8feature.User@7ef20235
         */
    }


}
