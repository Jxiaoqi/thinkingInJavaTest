package com.book.java_multithread_programming.t17;

/**
 * yield() 方法的作用是方法当前的cpu资源，将它让给其他的任务去占用cpu执行时间。
 * 但放弃的时间不确定，有可能刚刚放弃，马上又获得cpu时间片
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        long begin = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 50000000; i++) {
            Thread.yield();
            count = count + i;
        }
        long end = System.currentTimeMillis();
        System.out.println("用时： " + (end - begin) + "毫秒");
    }
}
