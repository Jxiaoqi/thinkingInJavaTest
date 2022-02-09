package com.book.java8feature;

/**
 *  Lambda表达式引用的局部变量必须是最终的（final）或事实上是final的；
 *  （这和Lambda启用线程有管理）
 */
public class VariableTest {

    public static void main (String[] args) {
        int portNumber = 1337;
        Runnable r = () -> System.out.println(portNumber);
//        portNumber = 1334;          //Varibale used in lambda expression should be final or effective final
        r.run();
    }
}
