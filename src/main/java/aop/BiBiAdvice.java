package aop;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 *  AOP 后置通知
 *
 * @author
 */
public class BiBiAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("哔哔");
    }
}
