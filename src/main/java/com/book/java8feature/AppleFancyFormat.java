package com.book.java8feature;

public class AppleFancyFormat implements AppleFormat {

    @Override
    public String accept (AppplesFilter.Apple apple) {
        String characteristic = apple.getWeight() > 150 ? "heavy" :
                "light";
        return characteristic;
    }
}
