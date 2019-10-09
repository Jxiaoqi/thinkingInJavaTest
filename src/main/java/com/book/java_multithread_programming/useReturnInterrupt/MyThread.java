package com.book.java_multithread_programming.useReturnInterrupt;

public class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("----------------");
            if (this.isInterrupted()) {
                System.out.println("停止了");
                return;
            }
        }
    }
}
