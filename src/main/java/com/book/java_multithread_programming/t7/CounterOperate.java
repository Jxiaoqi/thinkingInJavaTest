package com.book.java_multithread_programming.t7;

public class CounterOperate extends Thread {
    public CounterOperate() {
        System.out.println("CounterOperate --- begin");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());
        System.out.println("this.getName() = " + this.getName());
        System.out.println("this.isAlive() = " + this.isAlive());
        System.out.println("CounterOperate --- end");
    }
    
    @Override
    public void run() {
        System.out.println("run --- begin");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());
        System.out.println("this.getName() = " +  this.getName());
        System.out.println("this.isAlive() = " + this.isAlive());
        System.out.println("run --- end");
    }
    
    public static void main(String[] args) {
        CounterOperate counterOperate = new CounterOperate();
        Thread t1 = new Thread(counterOperate);
        t1.setName("A");
        System.out.println("main begin t1 isAlive = " + t1.isAlive());
        t1.start();
        System.out.println("main end t1 isAlive = " + t1.isAlive());
    }
}
