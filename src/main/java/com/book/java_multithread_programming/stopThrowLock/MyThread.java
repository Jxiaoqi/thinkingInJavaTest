package com.book.java_multithread_programming.stopThrowLock;

import org.apache.commons.lang3.StringUtils;

public class MyThread extends Thread {
    
    private SynchronizedObject synchronizedObject;
    
    public MyThread(SynchronizedObject synchronizedObject) {
        super();
        this.synchronizedObject = synchronizedObject;
    }
    
    
    @Override
    public void run() {
        synchronizedObject.printString("b", "bb");
    }
    
    public static void main(String[] args) {
        String dbName = "token_{0}";
        String aaa = StringUtils.replace(dbName, "{0}", "aaa");
        System.out.println(aaa);
        System.out.println(dbName);
    }
}
