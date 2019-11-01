package aop;

import java.lang.reflect.Proxy;

/**
 * AOP的原理就是创建代理，在运行时我们开发的业务逻辑类已经被替换成添加了增强代码的代理类，而Spring帮我们省略了这些繁琐和重复的步骤。
 */
public class Client {
    public static void main(String[] args) {
        //目标类
        UserService target = new UserServiceImpl();
        //代理操作类
        PerformanceMonitorUserService handler = new PerformanceMonitorUserService(target);
        //代理类实例
        UserService userService = (UserService) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), handler);
        userService.login("test", "test");
    }
}
