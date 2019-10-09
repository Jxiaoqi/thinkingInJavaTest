package com.book.java_multithread_programming.useStopMethodThreadTest;

public class MyThread extends Thread {
    
    private int i = 0;
    
    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i = " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
