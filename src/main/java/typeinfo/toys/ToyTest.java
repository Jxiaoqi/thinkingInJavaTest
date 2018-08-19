package typeinfo.toys;


import java.lang.reflect.Field;

import static util.Print.*;

/**
 *  * Class.java
 *  *    1.将 Toy 的默认构造器注释掉，会抛出InstantiationException ， 使用Class.newInstance()来创建的类，必须带有默认的
 *  * 构造器。
 *  *
 *  * @author xiaoqi
 *  * @since 18 八月 2018
 *  
 */

interface HasBatteries {
}

interface Waterproof {
}

interface Shoots {
}

class Toy {
    public Toy () {
    }

    public Toy (int i) {
    }
}

class FactoryToy extends Toy implements HasBatteries, Waterproof, Shoots {
    public FactoryToy () {
        super(1);
    }
}

public class ToyTest {

    static void printInfo (Class cc) {
        print("Class name : " + cc.getName() +
                " is interface ? [" + cc.isInterface() + "]");
        print("Simple name:  " + cc.getSimpleName());
        print("Canonical name : " + cc.getCanonicalName());
    }

    public static void main (String[] args) {
        Class c = null;
        try {
            c = Class.forName("typeinfo.toys.FactoryToy");
        } catch (ClassNotFoundException e) {
            print("can't find FacyToy");
            System.exit(1);
        }
        printInfo(c);
        for (Class aClass : c.getInterfaces()) {
            printInfo(aClass);
        }

        for (Field field : c.getDeclaredFields()) {
            print("field : " + field);
        }


        Class superclass = c.getSuperclass();
        Object obj = null;
        try {
            obj = superclass.newInstance();
        } catch (InstantiationException e) {
            print("can't InstantiationException");
            System.exit(1);
        } catch (IllegalAccessException e) {
            print("can't IllegalAccessException");
            System.exit(1);
        }
        printInfo(obj.getClass());
    }
}
