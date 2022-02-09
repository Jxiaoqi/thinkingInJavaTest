package com.book.java8feature;

public class PrintGrrenApple implements PrintApplePredicate {

    @Override
    public boolean test (AppplesFilter.Apple apple) {
        return apple.getColor().equals("green");
    }
}
