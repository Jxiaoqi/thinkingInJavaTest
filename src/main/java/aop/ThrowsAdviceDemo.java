package aop;


import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

public class ThrowsAdviceDemo implements ThrowsAdvice {
    
    public void afterThrowing(Method method, Object[] args, Object target, Exception ex) throws Throwable {
        System.out.println("抛出异常:" + ex.getMessage());
        System.out.println("异常处理...");
    }
}
