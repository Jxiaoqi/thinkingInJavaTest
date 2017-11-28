package java8feature;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  * TODO completion javadoc.
 *  *
 *  * @author xiaoqi
 *  * @since 02 十一月 2017
 *  
 */
public class AppplesFilterTest {

    public static void main (String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<Apple> greenApples = filterGreenApples(inventory);
        System.out.println(greenApples);

    }

    public static boolean isGreenApple(Apple apple) {
        if ("green".equals(apple.getColor())) {
            return true;
        }
        return false;
    }

    public static List<Apple> filterGreenApples(List<Apple> list) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {
            if (isGreenApple(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> list, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : list) {

        }
        return null;
    }
}
