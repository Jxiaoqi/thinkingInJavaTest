package com.book.java8feature.Chapter5;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 构建流 5.7
 *      之前使用了从集合生成流，本节将使用从值序列、数组、文本来创建流，甚至又生成函数来创建无限流
 *      1。获取当前工程路径： System.getProperty("user.dir")
 *      2。java7 的Paths类 NIO
 */
public class ConstructStream {

    public static void main (String[] args) {
        //1.由值创建流，使用静态方法Stream.of
        Stream<String> stream = Stream.of("Java8", "Lambdas", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);
        //由用empty得到一个空流
        Stream<String> emptyStream = Stream.empty();

        // 2.由数组创建流，使用静态方法Arrays.stream从数组创建一个流。它接受一个数组作为参数
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);


        // 由文件生成流，java中用于处理文件等I/o操作的NIO API (非阻塞)以更新，以便利用Stream API
        //java.nio.file.Files中的很多静态方法都会返回一个流。
        long uniqueWords = 0;
        String path = System.getProperty("user.dir") + "/target/classes/data.txt";
        try(Stream<String> lines = Files.lines(Paths.get(path), Charset.defaultCharset())) {
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                                .distinct()
                                .count();
            System.out.println(uniqueWords);
        } catch (Exception e) {
            e.printStackTrace();
        }

//由函数生成流： 创建无限流
        // 迭代 Stream.iterator
        //生成偶数序列
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        // 生成佩波那契元组数列
        Stream.iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .forEach(n -> System.out.println("(" + n[0] + "," + n[1] + ")"));

//生成
        //Stream.generate  IntStream.generate  接受一个Supplier<T>类型的lambda提供的新值
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

        IntStream ones = IntStream.generate(() -> 1);
        ones.limit(5).forEach(System.out::println);

        //生成无状态的值
        IntStream twos = IntStream.generate(new IntSupplier() {
            @Override
            public int getAsInt () {
                return 2;
            }
        });
        twos.limit(5).forEach(System.out::println);

        //有状态地生成，使用匿名内部类的成员变量，保存上一个和下一个值
        IntSupplier fib = new IntSupplier() {

            private int previous = 0;
            private int current = 1;

            @Override
            public int getAsInt () {
                int oldPrevious = this.previous;
                int nextValue = this.previous + this.current;
                this.previous = this.current;
                this.current = nextValue;
                return oldPrevious;
            }
        };
        IntStream.generate(fib).limit(10).forEach(System.out::println);

    }
}
