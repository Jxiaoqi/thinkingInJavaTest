package java8feature.time;

import java8feature.SortTest;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

public class DurationTest {
    public static void main(String[] args) {
        // 2017-01-05 10:07:00
        LocalDateTime from = LocalDateTime.of(2017, Month.JANUARY, 5, 10, 7, 0);
        // 2017-02-05 10:07:00
        LocalDateTime to = LocalDateTime.of(2017, Month.FEBRUARY, 5, 10, 7, 0);
    
        Duration between = Duration.between(from, to);
        System.out.println(between.toDays());
        System.out.println(between.toHours());
        System.out.println(between.toMinutes());
    }
}
