package aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

public class Client1 {
    public static void main(String[] args) throws Exception {
        Car car = new MyCar();
        AfterReturningAdvice afterReturningAdvice = new BiBiAdvice();
        MethodBeforeAdvice methodBeforeAdvice = new BeforeAdviceDemo();
        MethodInterceptor methodInterceptor = new AroundAdviceDemo();
        ThrowsAdvice throwsAdvice = new ThrowsAdviceDemo();
    
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(car);
        proxyFactory.setInterfaces(car.getClass().getInterfaces());
        
        proxyFactory.addAdvice(afterReturningAdvice);
        proxyFactory.addAdvice(methodBeforeAdvice);
        proxyFactory.addAdvice(methodInterceptor);
        proxyFactory.addAdvice(throwsAdvice);
    
        Car proxy = (Car) proxyFactory.getProxy();
        proxy.lock();
    }
}
