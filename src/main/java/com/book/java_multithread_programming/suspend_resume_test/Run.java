package com.book.java_multithread_programming.suspend_resume_test;

/**
 * suspend() 和 resume() 方法
 *      暂停线程意味着线程还可以回复运行。在java多线程中，可以使用suspend() 方法暂停线程，
 * 使用resume() 方法恢复线程的运行。
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(5000);
        
        //A段
        myThread.suspend();
        System.out.println("A= " + System.currentTimeMillis() + " i=" + myThread.getI());
        Thread.sleep(5000);
        System.out.println("A= " + System.currentTimeMillis() + " i=" + myThread.getI());
        
        //B段
        myThread.resume();
        Thread.sleep(5000);
        
        //C段
        myThread.resume();
        System.out.println("B = " + System.currentTimeMillis() + " i + " + myThread.getI());
        Thread.sleep(5000);
        System.out.println("B = " + System.currentTimeMillis() + " i + " + myThread.getI());
        
    }
}
