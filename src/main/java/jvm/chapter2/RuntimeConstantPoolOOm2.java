package jvm.chapter2;

/**
 * 运行结果：
 *  JDK 1.6 两个 false
 *  JDK 1.7  true false
 *
 *  原因：
 *      在JDK 1.6中, intern()方法会把首次遇到的字符串实例复制到永久代中，返回的也是永久代中这个字符串实例的引用
 *  而由StringBuilder创建的字符串实例在Java堆上，所以必然不是同一个引用，将返回false.
 *      在JDK 1.7中 ,intern() 的实现不会再复制实例，只是在常量池中记录首次出现的实例引用。 计算机软件是首次出现， 而java是已有的，在字符串
 *      常量池中已经有它的引用了，不符合"首次出现的原则"
 *
 *
 * @author xiaoqi
 * @since 12 十月 2018
 */
public class RuntimeConstantPoolOOm2 {

    public static void main (String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1 == str1.intern());


        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2 == str2.intern());

    }
}
