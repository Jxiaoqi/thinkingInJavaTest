package com.book.java_multithread_programming.daemon_thread;

/**
 * 在java中有两种线程，一种是用户线程，另外一种是守护（Daemon）线程
 * 什么是守护线程？守护线程是一种特殊的线程，它的特性有陪伴的含义，当进程中不存在非守护线程了，则守护线程
 * 自动销毁。典型的守护线程是垃圾回收线程，当进程中没有非守护线程了，则垃圾回收线程也就没有存在存在的必要了，
 * 自动销毁。
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyThread myThread = new MyThread();
            myThread.setDaemon(true);
            myThread.start();
            Thread.sleep(5000);
            System.out.println("我离开thread对象也不再打印了，也就是停止了！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
