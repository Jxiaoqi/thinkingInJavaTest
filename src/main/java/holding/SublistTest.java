package holding;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  *   ArrayList的subList结果不可强转成ArrayList，否则会抛出ClassCastException异常，
 *      即java.util.RandomAccessSubList cannot be cast to java.util.ArrayList.
 *      说明：subList 返回的是 ArrayList 的内部类 SubList，并不是 ArrayList ，而是 ArrayList 的一个视图，
 *      对于SubList子列表的所有操作最终会反映到原列表上。
 *  *
 *  * @author xiaoqi
 *  * @since 20 十二月 2017
 *  
 */
public class SublistTest {

    public static void main (String[] args) {

        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));

        /**
         * Exception in thread "main" java.lang.ClassCastException: java.util.ArrayList$SubList cannot be cast to java.util.ArrayList
         at holding.SublistTest.main(SublistTest.java:21)
         */
        //List<String> sublist = (ArrayList<String>)list.subList(1, 3);
        //System.out.println(sublist);

        List<String> sublist1 = list.subList(1, 3);
        System.out.println(sublist1);

        //sublist 返回的是ArrayList的内部类 sublist, 并不是ArrayList， 而是ArrayList的一个视图，对于sublist子列表的所有操作最终会反映到原列表上。
        sublist1.add("f");
        System.out.println(sublist1);
        System.out.println(list);

        /**
         * Exception in thread "main" java.util.ConcurrentModificationException
         at java.util.ArrayList$SubList.checkForComodification(ArrayList.java:1231)
         */
        //在subList场景中，高度注意对原集合元素个数的修改，会导致子列表的遍历、增加、删除均会产生ConcurrentModificationException 异常
        list.add("g");
        sublist1.stream().forEach(System.out::print);
        System.out.println(list);


    }
}
