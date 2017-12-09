package concurrency.ountdownlatchtest;

import java.util.concurrent.CountDownLatch;

/**
 *  *
 *  * 基本健康检查类
 *  * @author yuhao.jia
 *  * @since 08 十二月 2017
 *  
 */
public abstract class BaseHealthChecker implements Runnable {

    private String serviceName;
    private CountDownLatch countDownLatch;
    private boolean serviceUp;

    public BaseHealthChecker (String serviceName, CountDownLatch countDownLatch) {
        super();
        this.serviceName = serviceName;
        this.countDownLatch = countDownLatch;
        this.serviceUp = false;
    }

    @Override
    public void run () {
        try {
            verifyService();
            serviceUp = true;
        } catch (Exception e) {
            e.printStackTrace();
            serviceUp = false;
        } finally {
            countDownLatch.countDown();
        }
    }

    public String getServiceName () {
        return serviceName;
    }

    public boolean isServiceUp () {
        return serviceUp;
    }

    /**
     * 验证服务抽象方法
     */
    public abstract void verifyService();
}

