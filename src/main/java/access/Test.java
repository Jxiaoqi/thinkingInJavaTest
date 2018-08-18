package access;

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
//        List<String> array = Arrays.asList("a", "b", "c");
//        array.add(0, "x");
//        System.out.println(array);

        List<A> list = Arrays.asList(A.builder().a(3).build(),
                A.builder().a(1).build(),
                A.builder().a(4).build(),
                A.builder().a(7).build());

        List<A> list1 = list.stream().sorted(Comparator.comparing(A::getA).reversed()).collect(Collectors.toList());
        System.out.println(list1);
    }



}

@Data
@Builder
class A {
    int a;
}