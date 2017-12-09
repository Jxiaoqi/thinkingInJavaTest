package access;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  * TODO completion javadoc.
 *  *
 *  * @author xiaoqi
 *  * @since 27 十一月 2017
 *  
 */
public class Test {
    //这里还有疑问啊
    public static void main (String[] args) {
        List<String> array = Arrays.asList("a", "b", "c");
        array.add(0, "x");
        System.out.println(array);

    }



}
