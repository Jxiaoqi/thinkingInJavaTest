package com.book.java_multithread_programming.t11;

/**
 * interrupt()并没有使当前线程停止
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(2000);
        myThread.interrupt();
    }
}
