package aop;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author
 */
public class AroundAdviceDemo implements MethodInterceptor {
    
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("Hi, ");
        Object proceed = invocation.proceed();
        System.out.println("HI， bye bye");
        return proceed;
    }
}
