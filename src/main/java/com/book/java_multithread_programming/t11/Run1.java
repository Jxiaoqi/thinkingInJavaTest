package com.book.java_multithread_programming.t11;

/**
 * interrupt() 判断当前线程是否是停止状态， 线程的终端状态由该方法清除
 * 如果连续调用两次该方法，则第二次调用将返回false,第一次调用之后已清除了其终端状态
 */
public class Run1 {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(1000);
//        myThread.interrupt();
        Thread.currentThread().interrupt();
        System.out.println("是否停滞1 ？= " + Thread.interrupted());
        System.out.println("是否停滞2 ？= " + Thread.interrupted());
    }
}
