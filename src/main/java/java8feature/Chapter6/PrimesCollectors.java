package java8feature.Chapter6;

import com.sun.org.apache.xpath.internal.operations.Bool;
import java8feature.Predicate;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

/**
 *  * TODO completion javadoc.
 *  *
 *  * @author xiaoqi
 *  * @since 14 十月 2017
 *  
 */
public class PrimesCollectors implements
        Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {

    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier () {
        return () -> new HashMap<Boolean, List<Integer>>(2) {{
            put(true, new ArrayList<>());
            put(false, new ArrayList<>());
        }};
    }

    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator () {
        return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
            acc.get(isPrime(acc.get(true), candidate))
                    .add(candidate);
        };
    }


    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner () {
        return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>> map2) -> {
            map1.get(true).addAll(map2.get(true));
            map1.get(false).addAll(map2.get(false));
            return map1;
        };
    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher () {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics () {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
    }

    /**
     * 优化判断一个数是否为质数： 判断该数能否被小于该数平方根的某个质数整除
     * @param primes
     * @param candidate
     * @return
     */
    public static boolean isPrime(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return takeWhile(primes, i -> i <= candidate)
                        .stream()
                        .noneMatch(p -> candidate % p == 0);
    }

    /**
     * 返回一个列表中前一部分中所有满足谓词 P 的列表
     * @param list
     * @param p
     * @param <A>
     * @return
     */
    public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
        int i = 0;
        for (A a : list) {
            if (!p.test(a)) {
                return list.subList(0, i);
            }
            i++;
        }
        return list;
    }

    /**
     * 用自定义的收集器来为数字分区
     * @param n
     * @return
     */
    public static Map<Boolean, List<Integer>> partitionPrimesWithCustomController(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                        .collect(new PrimesCollectors());
    }

    /**
     * 也可以通过实现primeNumbersCollector核心逻辑的三个函数传给collect方法的重载版本来获得同样的结果
     * @param n
     * @return
     */
    public static Map<Boolean, List<Integer>> partitionPrimesWithCustomController1(int n) {
        return IntStream.rangeClosed(2, n).boxed().collect(
                () -> new HashMap<Boolean, List<Integer>>(2) {
            {
                put(true, new ArrayList<>());
                put(false, new ArrayList<>());
            }
        }, (acc, candidate) -> acc.get(isPrime(acc.get(true), candidate)).add(candidate),
                (map1, map2) -> {
            map1.get(true).addAll(map2.get(true));
            map1.get(false).addAll(map2.get(false));
        });
    }



}
