package concurrency.countdownlatchtest;

import java.util.concurrent.CountDownLatch;

/**
 *  * TODO completion javadoc.
 *  *
 *  * @author xiaoqi
 *  * @since 08 十二月 2017
 *  
 */
public class CacheHealthChecker extends BaseHealthChecker {

    public CacheHealthChecker (CountDownLatch countDownLatch) {
        super("Cache service", countDownLatch);
    }

    /**
     * 验证服务抽象方法
     */
    @Override
    public void verifyService () {
        System.out.println("Checking " + this.getServiceName());
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getServiceName() + "is UP");
    }
}
