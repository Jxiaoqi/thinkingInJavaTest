package java8feature.Chapter5;

import java8feature.Chapter4.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 使用流 5.2 映射
 */
public class StreamTest {

    public static void main (String[] args) {
        List<Dish> menu = Dish.menu;

        //将筛选行为作为参数传递给filter方法: 筛选出菜单中所有的素菜
        List<Dish> vegetarianDishes =
                menu.stream().filter(Dish::isVegetarian)
                .collect(toList());

        //流还支持一个distinct的方法，它会返回一个元素各异的流（根据流生成元素的hashCode和equals方法实现）
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        // limit(n)方法，该方法会返回一个不超过给你长度的流。
        List<Dish> dishes = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3)
                .collect(toList());
        System.out.println(dishes);

        //skip(n)方法，返回一个扔掉了前n个元素的流。
        List<Dish> dishes1 = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .skip(2)
                .collect(toList());

        //筛选前两道荤菜
        List<Dish> dishes2 = menu.stream()
                .filter(dish -> dish.getType() == Dish.Type.MEAT)
                .limit(2)
                .collect(toList());
        System.out.println(dishes2);

//映射

        List<String> dishNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(dishNames);

        //给定一个单词列表，想要返回另一个列表，显示每个单词中有几个字母。
        List<String> words = Arrays.asList("Java8", "Lambdas", "In", "action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .collect(toList());
        System.out.println(wordLengths);

        //提取每道菜名的长度。
        List<Integer> dishNameLengths = menu.stream()
                .map(Dish::getName)
                .map(String::length)
                .collect(toList());
        System.out.println(dishNameLengths);


//流的扁平化
        //对于一个单词表，如何返回一个列表，列出里面各不相同的字符呢？
        List<String> worlds = Arrays.asList("Hello", "world");

        //第一个版本  传递给map方法的lambda为每个单词返回了一个String[]
        List<String[]> distinctWord = worlds.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(toList());

        distinctWord.stream()
                .forEach(strings -> {
                    Arrays.stream(strings).forEach(System.out::println);
                });
        System.out.println(distinctWord);

        //1.尝试使用map和 Arryas.stream()
        String[] arrayOFWords = {"GoodBye", "World"};
        Stream<String> streamOfWorld = Arrays.stream(arrayOFWords);
        System.out.println(streamOfWorld);

        System.out.println("龙哥");
        worlds.stream()
                .map(word -> word.split(""))   //{[g,o,o,b],[]}
                .map(Arrays::stream)        //List<Stream<String>>
                .distinct()
                .forEach(System.out::println);          //该方法得到的是一个流的列表，没用

        //flatMap方法让你把每一个流中的每个值都换成另一个流，然后把所有的流连接起来称为一个流。
        //通常用于一对多操作是，将多数据项集合起来操作的场景。
        List<String> uniqueCharacters =
                worlds.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        System.out.println(uniqueCharacters);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares =
                numbers1.stream()
                .map(n -> n * n)
                .collect(toList());
        System.out.println(squares);

        //有两个数字列表，要求返回这两个数字列表的所有数对组合。
        List<Integer> numbers3 = Arrays.asList(1, 2, 3);
        List<Integer> numbers4 = Arrays.asList(3, 4);
        List<Integer[]> pairs =
                numbers3.stream()
                .flatMap(i -> numbers4.stream().map(j -> new Integer[]{i,j}))
                .collect(toList());

        //以上场景，只返回数对的和是3的倍数的数对
        List<Integer[]> pairs2 =
                numbers3.stream()
                .flatMap(i -> numbers4.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new Integer[]{i, j})
                        )
                        .collect(toList());

    }
}
