package com.book.java_multithread_programming.t7;


public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        System.out.println("begin == " + myThread.isAlive());
        myThread.start();
//        Thread.sleep(1000); 一秒之内该线程执行完自动关闭了，myThread.isAlive = false
        System.out.println("end == " + myThread.isAlive());
    }
}
