package util;


import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

/**
 * 基于redis分布式锁的集群定时任务实现
 *
 * 1.务必确保集群服务器时间一致，否则会失效 2.定时任务的最小间隔不允许小于1分钟
 *
 * @author
 */
public abstract class BaseSingleTaskTemplate<T> {

    public static final String TASK_TEMPLATE_TIME = "task_template_time";
    protected String redisKey;
    protected Jedis jedisClient;

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected BaseSingleTaskTemplate (String redisKey, Jedis jedisClient) {
        this.redisKey = redisKey;
        this.jedisClient = jedisClient;
    }

    protected abstract T process();

    protected void beforeProcess() {
        logger.info("SingleTaskTemplate begin, redisKey:{}", redisKey);
    }

    protected void afterProcess() {
    }

    protected void onSuccess() {
        logger.info("SingleTaskTemplate end, redisKey:{}", redisKey);
    }

    public T execute() {
        T t = null;
        long nowTime = System.currentTimeMillis();
        try {
            if (jedisClient.setnx(redisKey, nowTime + "") == 1L) {
                t = doExecute();
            } else {
                if (nowTime - Long.parseLong(jedisClient.get(redisKey)) > 58 * 1000) {
                    t = doExecute();
                }
            }
        } finally {
            jedisClient.expire(redisKey, 60);
        }
        return t;
    }

    private T doExecute() {
        try {
            Stopwatch stopwatch = Stopwatch.createStarted();
            beforeProcess();
            T result = process();
            onSuccess();
            // 添加监控
            long costMillis = stopwatch.elapsed(TimeUnit.MILLISECONDS);
            logger.info("SingleTaskTemplate redisKey = {} time = {} ms", redisKey, costMillis);
            return result;
        } catch (Exception e) {
            logger.error("", e);
            return null;
        } finally {
            afterProcess();
        }
    }

}