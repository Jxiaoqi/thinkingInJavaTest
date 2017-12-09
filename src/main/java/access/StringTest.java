package access;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

/**
 *  * TODO completion javadoc.
 *  *
 *  * @author xiaoqi
 *  * @since 05 十二月 2017
 *  
 */
public class StringTest {

    public static void main (String[] args) {

        byte[] test = new byte[21];
        test[0] = 1;
        test[1] = 3;
        test[2] = 4;
        test[3] = 1;
        test[4] = 1;
        test[5] = 0;
        test[6] = 9;

        String userNumber = new String(test);
        System.out.println(userNumber + "-----");

        Integer a = 89;
        Integer b = 95;
        System.out.println(a < b);

        List<String> array = Arrays.asList("1", "3", "2", "9");
        array.sort((a1, a2) -> a1.compareTo(a2));
        System.out.println(array);

        LocalDate start = LocalDate.of(2017, 11, 27);
        LocalDate end = LocalDate.of(2017, 12, 01);

        System.out.println(end.until(start, ChronoUnit.DAYS));
        System.out.println(start.until(end, ChronoUnit.MONTHS));
        System.out.println(start.until(end, ChronoUnit.WEEKS));

        Double sell = 821.6000;
        Double cost = 534.9200;
        System.out.println((sell - cost) / sell);
    }
}
