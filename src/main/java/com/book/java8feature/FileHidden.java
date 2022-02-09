package com.book.java8feature;


import java.io.File;
import java.io.FileFilter;

/**
 *  列出指定文件中的文件或文件名
 * */
public class FileHidden {

    public static void main(String[] args) {
        //JDK 7 及之前版本的写法
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
        for (int i = 0; i < hiddenFiles.length; i++) {
            System.out.println(hiddenFiles[i].getName());
        }

        /**
         * output
         * .DS_Store
            .git
            .idea
         */



        //JDK 8中的方法引用写法
        File[] hiddenFiles2 = new File(".").listFiles(File :: isHidden);
        for (File file : hiddenFiles2) {
            System.out.println(file.getName());
        }
    }

}
