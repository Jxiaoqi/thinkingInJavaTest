package com.book.java_multithread_programming.suspend_resume_nosameValue;

/**
 * suspend 与resume 方法的缺点-- 不同步（独占线程的方法锁定同步资源）
 */
public class Run {
    public static void main(String[] args) {
        MyObject myObject = new MyObject();
        
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                myObject.setValue("a", "a");
            }
        };
        thread1.setName("a");
        thread1.start();
    
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                myObject.printUserNameAndPassword();
            }
        };
        thread2.start();
    }
}
