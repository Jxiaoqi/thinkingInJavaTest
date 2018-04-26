package concurrency.simpledateformat;

import java.text.ParseException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  * TODO completion javadoc.
 *  *
 *  * @author xiaoqi
 *  * @since 10 一月 2018
 *  
 */
public class DateUtilTest {

    public static void main (String[] args) {
        final String pattern1 = "yyyy-MM-dd";
        final String pattern2 = "yyyy-MM";

        Thread t1 = new Thread() {

            @Override
            public void run () {
                try {
                    DateUtil.parse("1992-09-13", pattern1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t2 = new Thread() {

            @Override
            public void run () {
                try {
                    DateUtil.parse("2018-01", pattern2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t3 = new Thread() {

            @Override
            public void run () {
                try {
                    DateUtil.parse("1992-09-13", pattern1);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t4 = new Thread() {

            @Override
            public void run () {
                try {
                    DateUtil.parse("2018-01", pattern2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t5 = new Thread() {

            @Override
            public void run () {
                try {
                    DateUtil.parse("2018-01", pattern2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t6 = new Thread() {

            @Override
            public void run () {
                try {
                    DateUtil.parse("2018-01", pattern2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        };

        System.out.println("单线程执行");
        ExecutorService exec = Executors.newFixedThreadPool(1);
        exec.execute(t1);
        exec.execute(t2);
        exec.execute(t3);
        exec.execute(t4);
        exec.execute(t5);
        exec.execute(t6);

        System.out.println(Long.MAX_VALUE);
    }
}
