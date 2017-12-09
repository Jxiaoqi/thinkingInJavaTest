package concurrency.ountdownlatchtest;

import java.util.concurrent.CountDownLatch;

/**
 *  * 网络健康检查
 *  *
 *  * @author xiaoqi
 *  * @since 08 十二月 2017
 *  
 */
public class NetWorkHealthChecker extends BaseHealthChecker {


    public NetWorkHealthChecker (CountDownLatch countDownLatch) {
        super("NetWorkService", countDownLatch);
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
        System.out.println(this.getServiceName() + " is UP");
    }
}
