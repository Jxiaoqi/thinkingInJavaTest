package com.book.java8feature;


import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Apple extends Fruit {

    private Integer weight = 0;
    private String color = "";

    public Apple () {
    }

    public Apple (Integer weight) {
        this.weight = weight;
    }

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

    public static void main (String[] args) {
        List<Apple> apples = Lists.newArrayList();
        Map<Integer, Apple> map = apples.stream().collect(Collectors.toMap(Apple::getWeight, Function.identity()));
        System.out.println(map);
    }
}
