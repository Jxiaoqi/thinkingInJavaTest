package com.book.java_multithread_programming.suspend_resume_nosameValue;

import com.google.thirdparty.publicsuffix.PublicSuffixType;

public class MyObject {
    private String userName = "1";
    private String password = "11";
    
    public void setValue(String userName, String password) {
        this.userName = userName;
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("停止a线程！");
            Thread.currentThread().suspend();
        }
        this.password = password;
    }
    
    public void printUserNameAndPassword() {
        System.out.println(userName + " : " + password);
    }
}
