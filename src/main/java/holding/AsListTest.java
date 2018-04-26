package holding;

import java.util.Arrays;
import java.util.List;

/**
 *  *
 *  *   【强制】使用工具类Arrays.asList()把数组转换成集合时，不能使用其修改集合相关的方法，
 *      它的add/remove/clear方法会抛出UnsupportedOperationException异常。 说明：asList的返回对象是一个Arrays内部类，
 *      并没有实现集合的修改方法。Arrays.asList体现的是适配器模式，只是转换接口，后台的数据仍是数组。
 *      String[] str = new String[] { "you", "wu" };     List list = Arrays.asList(str);
 *          第一种情况：list.add("yangguanbao"); 运行时异常。
 *          第二种情况：str[0] = "gujin"; 那么list.get(0)也会随之修改。
 *  * @author xiaoqi
 *  * @since 22 十二月 2017
 *  
 */
public class AsListTest {

    public static void main (String[] args) {
        
        String[] str = new String[] { "you", "wu" };
        List list = Arrays.asList(str);
        list.stream().forEach(System.out::print);
        System.out.println();

        /**
         * Exception in thread "main" java.lang.UnsupportedOperationException
         at java.util.AbstractList.add(AbstractList.java:148)
         at java.util.AbstractList.add(AbstractList.java:108)
         at holding.AsListTest.main(AsListTest.java:27)
         */
        //第一种情况：list.add("yangguanbao"); 运行时异常。
        //list.add("jiji");
        list.stream().forEach(System.out::print);
        System.out.println();

        //第二种情况：str[0] = "gujin"; 那么list.get(0)也会随之修改
        str[0] = "gujin";
        list.stream().forEach(System.out::print);
    }

}
