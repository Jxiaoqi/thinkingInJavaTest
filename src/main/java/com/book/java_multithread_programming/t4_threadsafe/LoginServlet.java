package com.book.java_multithread_programming.t4_threadsafe;

public class LoginServlet {
    private static String userName;
    private static String passWord;
    
    public static void doPost(String userName, String passWord) {
        try {
            userName = userName;
            if ("a".equals(userName)) {
                Thread.sleep(5000);
            }
            passWord = passWord;
            System.out.println("userName = " + userName + "; passWord = " + passWord);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
