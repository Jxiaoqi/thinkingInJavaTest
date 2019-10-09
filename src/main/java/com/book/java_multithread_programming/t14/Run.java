package com.book.java_multithread_programming.t14;

/**
 * 在线程sleep状态下停止该线程(interrupt())，会进入catch语句，并且清除停止状态值(isInterrupted())
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.start();
            Thread.sleep(200);
            myThread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
    }
}
