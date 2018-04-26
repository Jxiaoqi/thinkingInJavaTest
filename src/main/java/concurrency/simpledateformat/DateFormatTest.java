package concurrency.simpledateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 *  * SimpleDateFormat 不是线程安全的
 *  *   https://www.cnblogs.com/zemliu/archive/2013/08/29/3290585.html
 *
 *     注意：SimpleDateFormat 的  parsedDate = calb.establish(calendar).getTime(); 中有一个 cal.clear(); 会产生并发问题。
 *  * @author yuhao.jia
 *  * @since 05 一月 2018
 *  
 */
public class DateFormatTest extends Thread {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    private String name;
    private String dateStr;
    private boolean sleep;

    public DateFormatTest (String name, String dateStr, boolean sleep) {
        this.name = name;
        this.dateStr = dateStr;
        this.sleep = sleep;
    }

    @Override
    public void run () {
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(name + " :date " + date);
    }

    public static void main (String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(new DateFormatTest("A", "2017-01-05", true));
        executor.execute(new DateFormatTest("B", "2018-01-05", false));

        executor.shutdown();
    }
}
