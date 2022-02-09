package com.book.java8feature.Chapter4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamBasic {

    public static void main (String[] args) {
        //java7
        getLowCaloricDishesNamesInJava7(Dish.menu).forEach(System.out::println);
        //java8
        getLowCaloricDishesNamesInJava8(Dish.menu).forEach(System.out :: println);
    }

    public static List<String> getLowCaloricDishesNamesInJava7(List<Dish> dishes) {
        List<Dish> lowCaloriesDishes = new ArrayList<>();
        for (Dish d : dishes) {
            if (d.getCalories() > 400) {
                lowCaloriesDishes.add(d);
            }
        }
        List<String> lowCaloricDishesNames = new ArrayList<>();
        Collections.sort(lowCaloriesDishes, new Comparator<Dish>() {
            @Override
            public int compare (Dish o1, Dish o2) {
                return Integer.compare(o1.getCalories(), o2.getCalories());
            }
        });
        for (Dish d : lowCaloriesDishes) {
            lowCaloricDishesNames.add(d.getName());
        }
        return lowCaloricDishesNames;
    }

    public static List<String> getLowCaloricDishesNamesInJava8(List<Dish> dishes) {
        List<String> lowCaloriesDishes =
        dishes.stream()
                .filter(dish -> dish.getCalories() > 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
        return lowCaloriesDishes;
    }
}
