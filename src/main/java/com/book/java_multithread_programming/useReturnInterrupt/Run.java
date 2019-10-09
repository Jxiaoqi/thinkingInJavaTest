package com.book.java_multithread_programming.useReturnInterrupt;

/**
 * 将方法interrupt()与return结合使用也能实现停止线程的效果。
 * 不过还是建议使用"抛异常"法来实现线程的停止， 因为在catch块中可以对异常的信息进行相关的处理，
 * 而且使用异常流能更好、更方便地控制程序的运行流程，不至于代码中出现多个return 造成污染
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();
        Thread.sleep(2000);
        myThread.interrupt();
    }
}
