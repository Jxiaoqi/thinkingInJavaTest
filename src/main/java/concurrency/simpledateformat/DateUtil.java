package concurrency.simpledateformat;

import com.google.common.collect.Lists;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  * TODO completion javadoc.
 *  *
 *  * @author xiaoqi
 *  * @since 10 一月 2018
 *  
 */
public class DateUtil {

    private static final Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<>();

    private static SimpleDateFormat getSdf (final String pattern) {
        ThreadLocal<SimpleDateFormat> t1 = sdfMap.get(pattern);
        if (t1 == null) {

            System.out.println("put new sdf of pattern " + pattern + " to map");

            t1 = new ThreadLocal<SimpleDateFormat>() {

                @Override
                protected SimpleDateFormat initialValue () {
                    System.out.println("thread: " + Thread.currentThread() + " init pattern: " + pattern);
                    return new SimpleDateFormat(pattern);
                }
            };
            sdfMap.put(pattern, t1);
        }

        return t1.get();
    }

    /**
     * 日期格式化
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String format (Date date, String pattern) {
        return getSdf(pattern).format(date);
    }

    /**
     * 日期解析
     *
     * @param date
     * @param pattern
     * @return
     * @throws ParseException
     */
    public static Date parse (String date, String pattern) throws ParseException {
        return getSdf(pattern).parse(date);
    }


    public static List<LocalDate> getThisMonthAllDays () {
        List<LocalDate> dates = Lists.newArrayList();
        LocalDate startTime = LocalDate.now().withDayOfMonth(1);
        for (int i = 0; i < startTime.lengthOfMonth(); i++) {
            dates.add(startTime.plusDays(i));
        }
        return dates;
    }

}
