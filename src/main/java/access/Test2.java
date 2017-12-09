package access;


import java.util.HashSet;
import java.util.Set;

/**
 *  * TODO completion javadoc.
 *  *
 *  * @author xiaoqi
 *  * @since 27 十一月 2017
 *  
 */
public class Test2 {

    public static void main (String[] args) {
        Set<String> set1 = new HashSet<>();
        set1.add("a");
        set1.add("b");
        set1.add("c");

        Set<String> set2 = new HashSet<>();
        set2.add("a");
        set2.add("b");
        set2.add("d");

        Set<String> setAll = new HashSet<>();
        setAll.addAll(set1);
        setAll.addAll(set2);
        System.out.println(setAll);

        Double a = 42.0;
        Integer b = 7021;
        Double d = a/b;
        System.out.println(d);

        Integer i1 = 67;
        Integer i2 = 51;
        System.out.println((double)i2 / i1);

        
    }
}
