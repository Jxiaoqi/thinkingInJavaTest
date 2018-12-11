package jvm.chapter2;


import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池导致的内存溢出异常
 *
 *  VM Args : -XX:PermSize=10M -XX:MaxPermSize=10M
 *      运行时常量池是方法区的一部分，JDK 1.7逐渐"去永久代"
 *      在1.6及之前的版本中由于常量池分配在永久代中，我们可以通过  -XX:PermSize=10M -XX:MaxPermSize=10M
 *    限制方法区大小，从而间接限制常量池的容量。
 *
 *
 * 运行结果：
 *  1。6      Exception in thread "main" java.lang.OutOfMemoryError: PermGen space
            at java.lang.String.intern(Native Method)
            at jvm.chapter2.RuntimeConstantPoolOOm.main(RuntimeConstantPoolOOm.java:19)

    1.7 while循环将一直运行下去

 *
 * @author xiaoqi
 * @since 12 十月 2018
 */
public class RuntimeConstantPoolOOm {

    public static void main (String[] args) {
        //实用list 保持着常量池的引用，避免 full gc 回收常量池行为
        List<String> list = new ArrayList<String>();
        //10MB的 PermSize在Integer的范围内足够产生OOM， 大约 1885506 会发生
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++));
        }
    }
}
