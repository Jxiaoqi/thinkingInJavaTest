package holding;

import java.util.ArrayList;
import java.util.List;

/**
 *  *  ArrayList(Collection<? extends E> c) test
 *  *
 *  * @author xiaoqi
 *  * @since 10 一月 2018
 *  
 */
public class ArrayListTest {

    public static void main (String[] args) {
        List<String> list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");

        List<String> list2 = new ArrayList<>(list);
        System.out.println(list2);
    }
}
