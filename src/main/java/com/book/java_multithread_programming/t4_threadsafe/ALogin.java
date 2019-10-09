package com.book.java_multithread_programming.t4_threadsafe;

public class ALogin extends Thread {
    @Override
    public void run() {
        LoginServlet.doPost("a", "aa");
    }
}
