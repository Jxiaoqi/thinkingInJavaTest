package com.book.java_multithread_programming.useStopMethodThreadTest1;

public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            this.stop();
        } catch (ThreadDeath e) {
            System.out.println("进入了catch() 方法");
        }
    }
}
