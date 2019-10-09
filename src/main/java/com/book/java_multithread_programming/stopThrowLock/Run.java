package com.book.java_multithread_programming.stopThrowLock;

/**
 * 使用stop() 释放锁将会给数据造成不一致的结果。如果出现这样的情况，程序处理的数据就有
 * 可能遭到破坏，最终导致程序执行的流程错误。
 *
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        SynchronizedObject synchronizedObject = new SynchronizedObject();
        MyThread myThread = new MyThread(synchronizedObject);
        myThread.start();
        Thread.sleep(500);
        myThread.stop();
        System.out.println(synchronizedObject.getUsername() + " " + synchronizedObject.getPassword());
        
    }
}
