package com.book.java8feature.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeTest {
    
    public static void main(String[] args) {
        LocalDateTime ldt1 = LocalDateTime.of(2017, Month.APRIL, 17, 23, 53, 40);
        System.out.println(ldt1);
    
        LocalDate localDate = LocalDate.of(2017, Month.JANUARY, 4);
        System.out.println(localDate);
    
        LocalTime localTime = LocalTime.of(17, 23, 52);
        System.out.println(localTime);
    
        LocalDateTime localDateTime = localDate.atTime(localTime);
        System.out.println(localDateTime);
    
        LocalDate localDate1 = ldt1.toLocalDate();
        LocalTime localTime1 = ldt1.toLocalTime();
        System.out.println(localDate1 + "----" + localTime1);
    
    }
}
