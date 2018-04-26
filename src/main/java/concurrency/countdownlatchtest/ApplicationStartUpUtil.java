package concurrency.countdownlatchtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 *  *
 *  *
 *  * @author xiaoqi
 *  * @since 08 十二月 2017
 *  
 */
public class ApplicationStartUpUtil {

    /**
     *  List of service checkers
     */
    private static List<BaseHealthChecker> services;

    /**
     * this latch will be userd to wait on
     */
    private static CountDownLatch countDownLatch;

    private final static ApplicationStartUpUtil INSTANCE = new ApplicationStartUpUtil();

    public static ApplicationStartUpUtil getInstance() {
        return INSTANCE;
    }

    public static boolean checkExternalServices() throws Exception {
        //Initialize the latch with number of service checkers
        countDownLatch = new CountDownLatch(3);
        //All add checker in lists
        services = new ArrayList<>();
        services.add(new NetWorkHealthChecker(countDownLatch));
        services.add(new DataBaseHealthChecker(countDownLatch));
        services.add(new CacheHealthChecker(countDownLatch));
        //start service checkers using executor framework
        Executor executor = Executors.newFixedThreadPool(services.size());
        for (BaseHealthChecker baseHealthChecker : services) {
            executor.execute(baseHealthChecker);
        }
        //now wait till all services are checked
        countDownLatch.await();
        //services are file and now proceed startup
        for (BaseHealthChecker baseHealthChecker : services) {
            if (!baseHealthChecker.isServiceUp()) {
                return false;
            }
        }
        return true;
    }






}
