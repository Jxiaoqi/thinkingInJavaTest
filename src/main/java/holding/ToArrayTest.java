package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  *
 *  *   【强制】使用集合转数组的方法，必须使用集合的toArray(T[] array)，传入的是类型完全一样的数组，大小就是list.size()
 *  * @author xiaoqi
 *  * @since 22 十二月 2017
 *  
 */
public class ToArrayTest {

    public static void main (String[] args) {

        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList("a", "b", "c", "d", "e"));

        String[] array = new String[list.size()];
        array = list.toArray(array);
        Arrays.stream(array).forEach(System.out::print);
        System.out.println();

        //使用toArray带参方法，入参分配的数组空间不够大时，toArray方法内部将重新分配内存空间，并返回新数组地址
        String[] array2 = new String[3];
        array2 = list.toArray(array2);
        Arrays.stream(array2).forEach(System.out::print);
        System.out.println();

        // 如果数组元素大于实际所需，下标为[ list.size() ]以后的数组元素将被置为null，其它数组元素保持原值，因此最好将方法入参数组大小定义与集合元素个数一致。
        String[] array3 = new String[7];
        array3 = list.toArray(array3);
        Arrays.stream(array3).forEach(System.out::print);
        System.out.println();

        /**
         *  Exception in thread "main" java.lang.ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.String;
            at holding.ToArrayTest.main(ToArrayTest.java:42)
         */
        // 直接使用toArray无参方法存在问题，此方法返回值只能是Object[]类，若强转其它类型数组将出现ClassCastException错误。
        String[] array4 = (String[]) list.toArray();
        Arrays.stream(array4).forEach(System.out::print);

    }
}
