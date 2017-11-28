package access;

import sun.tools.tree.DoubleExpression;

import java.util.Arrays;
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

        Integer a = 42;
        Integer b = 7021;
        Double d = (double)a/b;
        System.out.println(d);

        
    }
}
