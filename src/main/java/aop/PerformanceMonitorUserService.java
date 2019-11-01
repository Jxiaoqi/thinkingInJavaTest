package aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class PerformanceMonitorUserService implements InvocationHandler {
    
    private Object target;
    
    public PerformanceMonitorUserService(Object target) {
        this.target = target;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        Object invoke = method.invoke(target, args);
        long end = System.currentTimeMillis();
        System.out.println("PerformanceMonitorUserService: 用户" + args[0] + "登录耗时" + (end - start) + "毫秒");
        return invoke;
    }
}
