package com.book.java_multithread_programming.extthread;

/**
 * 留意i-- 和System.out.println() 异常
 *  概率性打印除了i 相等的情况， 虽然println() 方法在内部是同步的，但i-- 的操作在进入
 *  println() 之前发生了非线程安全问题
 *
 *  public void println(String x) {
 *         synchronized (this) {
 *             print(x);
 *             newLine();
 *         }
 *     }
 */
public class MyThread extends Thread {
    
    private int i = 5;
    
    @Override
    public void run() {
        System.out.println("i = " + (i--) + " threadName = " + Thread.currentThread().getName());
    }
}
