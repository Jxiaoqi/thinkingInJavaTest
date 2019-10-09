package com.book.java_multithread_programming.t4_threadsafe;

public class Run {
    public static void main(String[] args) {
        ALogin aLogin = new ALogin();
        aLogin.start();
    
        BLogin bLogin = new BLogin();
        bLogin.start();
    }
}
