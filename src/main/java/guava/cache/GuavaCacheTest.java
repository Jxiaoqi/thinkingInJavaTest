package guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.collect.Lists;
import java8feature.SortTest;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static sun.misc.PostVMInitHook.run;

public class GuavaCacheTest {
    
    @Test
    public void cacheBuild() {
        Cache<String, Object> cache = CacheBuilder.newBuilder().build();
        cache.put("word", "Hello guava cache");
        System.out.println(cache.getIfPresent("word"));
    }
    
    @Test
    public void cacheMaximumSize() {
        Cache<String, Object> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .build();
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");
    
        System.out.println("第一个值: " +  cache.getIfPresent("key1"));
        System.out.println("第二个值: " + cache.getIfPresent("key2"));
        System.out.println("第三个值: " + cache.getIfPresent("key3"));
    }
    
    @Test
    public void expireAfterWrite() throws InterruptedException {
        Cache<String, Object> cache = CacheBuilder.newBuilder()
                .expireAfterWrite(3, TimeUnit.SECONDS)
                .build();
        
        cache.put("key1", "value");
        int time = 1;
        while (true) {
            System.out.println("第" + time++ + "次值: " + cache.getIfPresent("key1"));
            Thread.sleep(1000);
        }
    }
    
    @Test
    public void expireAfterAccess() throws InterruptedException {
        Cache<String, Object> cache = CacheBuilder.newBuilder()
                .expireAfterAccess(3, TimeUnit.SECONDS)
                .build();
        
        cache.put("key1", "value");
        int time = 1;
        while (true) {
            Thread.sleep(1000 * time);
            System.out.println("休眠" + time++ + "后的值: " + cache.getIfPresent("key1"));
        }
    }
    
    @Test
    public void weakValues() {
        Cache<Object, Object> cacheBuilder = CacheBuilder.newBuilder()
                .maximumSize(2)
                .weakValues()
                .build();
        Object value = new Object();
        cacheBuilder.put("key1", value);
        
        //原对象不再有强引用
        value = new Object();
        System.gc();
        System.out.println(cacheBuilder.getIfPresent("key1"));
    }
    
    @Test
    public void invalidate() {
        Cache<Object, Object> cacheBuilder = CacheBuilder.newBuilder()
                .build();
        cacheBuilder.put("key1", "value1");
        cacheBuilder.put("key2", "value2");
        cacheBuilder.put("key3", "value3");
    
        List<String> list = Lists.newArrayList("key1", "key2");
        cacheBuilder.invalidateAll(list);
    
        System.out.println(cacheBuilder.getIfPresent("key1"));
        System.out.println(cacheBuilder.getIfPresent("key2"));
        System.out.println(cacheBuilder.getIfPresent("key3"));
    }
    
    /**
     * 移除监听器
     */
    @Test
    public void removalListenerTest() {
        RemovalListener<String, String> listener = removalNotification ->
                System.out.println("[" + removalNotification.getKey() + ":" + removalNotification.getValue() + "] is removed");
        
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .removalListener(listener)
                .build();
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");
        cache.put("key4", "value4");
        cache.put("key5", "value5");
        cache.put("key6", "value6");
        cache.put("key7", "value7");
        cache.put("key8", "value8");
        
    }
    
    
    /**
     * 自动加载
     */
    @Test
    public void callableTest() {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .build();
        int a = 15;
        new Thread(() -> {
            System.out.println("thread1");
            System.out.println("获取的局部变量： " + a);
            try {
                String value = cache.get("key", new Callable() {
                    @Override
                    public Object call() throws Exception {
                        System.out.println("load1");
                        Thread.sleep(1000);
                        return "auto load by Callable1";
                    }
                });
                System.out.println("thread1 : " + value);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
    
        }).start();
        
        new Thread(() -> {
            System.out.println("thread2");
            System.out.println("获取的局部变量： " + a);
            try {
                String value = cache.get("key", new Callable() {
                    @Override
                    public Object call() throws Exception {
                        System.out.println("load2");
                        Thread.sleep(1000);
                        return "auto load by Callable2";
                    }
                });
                System.out.println("thread2 : " + value);
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }).start();
    
    
        System.out.println("stop");
    }
}
