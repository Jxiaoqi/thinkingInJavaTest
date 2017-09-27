package java8feature;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * 演示函数式接口Consumer
 */
public class ConsumerTest {

    public static <T> void forEach (List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }

    public static void main (String[] args) {
        List<String> list = Arrays.asList("a","v","b","e");
        forEach(list, (String s) -> System.out.println(s));

        int portNumber = 1337;
        Runnable r = () -> System.out.println(portNumber);
        r.run();
    }

}
