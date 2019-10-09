package com.book.java_multithread_programming.suspend_resume_deal_lock;

/**
 *
 * 1.在使用suspend() 与 resume方法时，如果使用不当，极易造成公共空间的同步对象的独占，使得其他线程
 * 无法访问公共同步对象。(两个方法都是以独占的方法锁定线程的同步资源，导致同步资源被锁定)
 *
 *
 */
public class Run {
    public static void main(String[] args) {
        try {
            SynchronizedObject synchronizedObject = new SynchronizedObject();
            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    synchronizedObject.printString();
                }
            };
    
            thread1.setName("a");
            thread1.start();
            Thread.sleep(1000);
    
            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    System.out.println("thread2 启动了，但进入不了printString() 方法！只打印了1一个being");
                    System.out.println("因为printString()方法被a线程锁定并且永远suspend暂停了!");
                    synchronizedObject.printString();
                }
            };
            
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
