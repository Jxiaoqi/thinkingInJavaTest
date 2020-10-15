package java8feature.time;

import java.time.LocalTime;

public class LocalTimeTest {
    
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.of(17, 23, 52);
        System.out.println(localTime);
        
        int hour = localTime.getHour();
        System.out.println(hour);
    
        int minute = localTime.getMinute();
        System.out.println(minute);
    
        int second = localTime.getSecond();
        System.out.println(second);
    }
}
