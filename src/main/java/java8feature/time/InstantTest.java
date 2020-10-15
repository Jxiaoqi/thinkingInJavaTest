package java8feature.time;

import java.time.Instant;

public class InstantTest {
    
    public static void main(String[] args) {
        //1970-01-01 00:00:00到现在的时间
        Instant instant = Instant.ofEpochSecond(120, 10000);
        System.out.println(instant);
    }
}
