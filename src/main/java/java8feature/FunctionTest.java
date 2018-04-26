package java8feature;


import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 *  java.util.Function<T, R>接口定义了一个叫做apply的方法，它接受一个范型T的对象，
 *  并返回一个范型R的对象。
 *      如果你需要定义一个lambda，将输入对象的信息映射到输出，就可以使用这个接口，。
 */
public class FunctionTest {


    public static <T, R> List<R> map(List<T> list,
                                     Function<T, R> function) {

        List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }

    public static void main (String[] args) {

        List<Integer> l = map(Arrays.asList("lambdas", "in", "action"),
                (String s) -> s.length()
        );
        System.out.println(l);

        LocalDateTime mondayOfLastFourWeek = LocalDateTime.now().minusWeeks(-4).with(ChronoField.DAY_OF_WEEK, 1);
        System.out.println(mondayOfLastFourWeek);
    }

}
