package access;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  *
 *  * 在这里有个疑问啊 ？ 为什么 = 和 addAll()执行的结果不一样呢？
 *      方法里面的局部变量，在方法执行完成就会被回收释放，外面引用方法里的局部变量内存输出时已经被回收了
 *      对象存在堆中，局部变量只持有对象的引用 存放在栈中，方法结束后栈上的空间被释放
 *  * @author xiaoqi
 *  * @since 04 十二月 2017
 *  
 */
public class TempTest {

    public static void main (String[] args) {
        List<String> list = new ArrayList<>();
        TempTest tempTest = new TempTest();
        tempTest.test(list);
        System.out.println("main方法中的list: " + list);

        List<String> list1 = new ArrayList<>();
        tempTest.test1(list1);
        System.out.println("main方法中的list: " + list1);

        BigDecimal a = BigDecimal.valueOf(0);
        System.out.println(a);

    }

    public void test(List<String> list) {
        list = Arrays.asList("a", "b", "c");
        System.out.println("test方法中的list: " + list);
    }

    public void test1(List<String> list) {
        list.addAll(Arrays.asList("a", "b", "c"));
        System.out.println("test1方法中的list: " + list);
    }

}
