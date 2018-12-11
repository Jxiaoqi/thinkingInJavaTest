package util;

import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.JedisCluster;

/**
 * 简单的锁实现版本
 *
 */

@Slf4j
public class LockService {

    //@Autowired
    private JedisCluster redisClient;

    public boolean grabLock(String key, String value, int expire) {
        log.info("尝试获得锁, key: '{}', value: '{}', expire: '{}'", key, value, expire);
        if (redisClient.setnx(key, value) == 1) {
            log.info("成功获得锁, key: '{}'", key);
            redisClient.expire(key, expire);
            return true;
        } else {
            // 失效时间未设置成功
            if (redisClient.ttl(key) == -1) {
                redisClient.expire(key, expire);
            }
        }
        log.info("获得锁失败 key: '{}'", key);
        return false;
    }

    public boolean releaseLock(String key) {
        return redisClient.del(key) > 0;
    }
}
