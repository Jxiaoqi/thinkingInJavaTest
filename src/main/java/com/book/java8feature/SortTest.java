package com.book.java8feature;

import net.sourceforge.pinyin4j.PinyinHelper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  * 按照汉字首字母排序 pinyin4j的使用
 *      https://mvnrepository.com/artifact/com.belerweb/pinyin4j
 *  *
 *  * @author yuhao.jia
 *  * @since 18 一月 2018
 *  
 */
public class SortTest {

    public static void main (String[] args) {
        List<String> list = new ArrayList<>();
        list.add("王玉豪");
        list.add("贾玉豪");
        list.add("李玉豪");

        list = list.stream().sorted((o1, o2) -> {
            char c1 = o1.charAt(0);
            char c2 = o2.charAt(0);
            return PinyinHelper.toHanyuPinyinStringArray(c1)[0].compareTo(PinyinHelper.toHanyuPinyinStringArray(c2)[0]);
        }).collect(Collectors.toList());
        System.out.println(list);

        System.out.println(BigDecimal.ZERO.setScale(2).toString());
    }
}
