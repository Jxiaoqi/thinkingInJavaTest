package jvm.chapter2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 借助CGLib 使方法区出现内存溢出异常
 *      方法区用于存放Class的相关信息，如类名、访问修饰符号、常量池、字段描述、方法描述。
 *
 * @author xiaoqi
 * @since 12 十月 2018
 */
public class JavaMethodAreaOOm {

    public static void main (final String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept (Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return method.invoke(0, args);
                }
            });
            enhancer.create();
        }
    }

    static class OOMObject {

    }
}
