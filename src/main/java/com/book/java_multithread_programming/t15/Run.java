package com.book.java_multithread_programming.t15;

/**
 * 试图将已经中断的线程(interrupt())调用sleep() 方法，也会抛出 java.lang.InterruptedException: sleep interrupted
 */
public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        myThread.interrupt();
        System.out.println("end!");
    }
}
