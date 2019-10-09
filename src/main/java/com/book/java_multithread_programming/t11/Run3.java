package com.book.java_multithread_programming.t11;

public class Run3 {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
//        Thread.currentThread().interrupt();
        System.out.println("是否停滞 1 ? = " + thread.isInterrupted());
        System.out.println("是否停滞2 ？ = " + thread.isInterrupted());
    }
}
