package java8feature;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 *  * flatMap
 *  *
 *  * @author xiaoqi
 *  * @since 18 五月 2018
 *  
 */
public class FlatMapTest {

    public static void main (String[] args) {

        List<List<String>> lists = Lists.newArrayList();

        List<String> list = Lists.newArrayList();
        list.add("a");
        list.add("b");

        List<String> list2 = Lists.newArrayList();
        list.add("c");
        list.add("d");

        List<String> list3 = Lists.newArrayList();
        list.add("e");
        list.add("f");

        lists.add(list);
        lists.add(list2);
        lists.add(list3);

        List<String> stringList = lists.stream().flatMap(strings -> strings.stream()).collect(Collectors.toList());
        System.out.println(stringList);

    }
}
