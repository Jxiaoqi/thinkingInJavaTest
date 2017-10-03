package java8feature.Chapter4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 外部迭代与内部迭代 4.3
 *
 */
public class ForeachTest {

    public static void main (String[] args) {

        List<Dish> menu = Dish.menu;

        //集合： 用for-each 循环外部迭代
        List<String> names = new ArrayList<>();
        for (Dish dish : menu) {
            names.add(dish.getName());
        }

        //集合： 用背后的迭代器做外部迭代
        Iterator<Dish> iterator = menu.iterator();
        while (iterator.hasNext()) {
            Dish d = iterator.next();
            names.add(d.getName());
        }

        //流：内部迭代。
        List<String> names1 = menu.stream().
                map(Dish::getName).
                collect(Collectors.toList());
        System.out.println(names1);
    }
}
