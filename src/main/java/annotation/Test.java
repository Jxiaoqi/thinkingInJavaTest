package annotation;

import java.lang.reflect.Method;

public class Test {
    @Hello("hello")
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Test> testClass = Test.class;
        Method main = testClass.getMethod("main", String[].class);
        Hello annotation = main.getAnnotation(Hello.class);
    
    }
}
