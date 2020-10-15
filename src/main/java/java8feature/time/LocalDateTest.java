package java8feature.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;


public class LocalDateTest {
    
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2017, 1, 4);
        //获取年份
        int year = localDate.getYear();
        System.out.println(year);
        
        //获取月份
        Month month = localDate.getMonth();
        System.out.println(month);
        
        //当月的第几天
        int dayOfMonth = localDate.getDayOfMonth();
        System.out.println(dayOfMonth);
        
        //获取星期几
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println(dayOfWeek);
        
        //月份有多少天
        int lengthOfMonth = localDate.lengthOfMonth();
        System.out.println(lengthOfMonth);
        
        //这一年有多少天
        int lengthOfYear = localDate.lengthOfYear();
        System.out.println(lengthOfYear);
        
        //是否是闰年
        boolean leapYear = localDate.isLeapYear();
        System.out.println(leapYear);
        
        //获取当前日期
        LocalDate now = LocalDate.now();
        System.out.println(now);
        
    }
}
