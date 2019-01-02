package reflect;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * 理解Class类 以及 获取Class对象的三种方式
 *
 * @author xiaoqi
 * @since 13 十二月 2018
 */
public class ReflectionTest {

    @Test
    public void testClass () throws ClassNotFoundException {
        Class clazz = null;

        //1.得到class对象
        clazz = Person.class;
        //2.得到字段的数组
        Field[] declaredFields = clazz.getDeclaredFields();

        //获取对象的三种方式
        //1
        clazz = Person.class;
        //2
        Person person = new Person();
        clazz = person.getClass();

        Object obj = new Person();
        clazz = obj.getClass();
        //3
        String className = "reflect.Person";
        clazz = Class.forName(className);


        //字符串的例子
        clazz = String.class;
        clazz = "javaTest".getClass();
        clazz = Class.forName("java.lang.String");

        System.out.println();
    }

    @Test
    public void testNewInstance () throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        //获取Class对象
        String className = "reflect.Person";
        Class clazz = Class.forName(className);

        Object obj = clazz.newInstance();
        System.out.println(obj);

    }
}
