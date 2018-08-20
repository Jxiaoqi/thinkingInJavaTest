package typeinfo;

import org.apache.poi.util.SystemOutLogger;

import javax.sound.midi.Soundbank;
import java.util.Random;

/**
 *  * 类字面常量
 * *  类似： ClassIntialization.class
 *  *   1: Class.forName() 和 ****.class 引用Class对象的区别
 * *   2. 调用 static 和 static final 域对对象初始化的影响
 * *   3 ：基本数据类型中的 TYPE
 * *   4：为了使用类而做的准备工作： 加载，链接，初始化
 * 5：对象的初始化被延迟到了对静态方法（构造器隐式地是静态的）或者非常数静态域进行首次引用是才执行
 *  * @author xiaoqi
 *  * @since 20 八月 2018
 *  
 */

class Initable {
    static final int staticFinal = 47;
    static final int getStaticFinal2 =
            ClassIntialization.rand.nextInt(1000);
    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}


public class ClassIntialization {
    public static Random rand = new Random(47);

    public static void main (String[] args) throws Exception {
        Class<Initable> initableClass = Initable.class;
        System.out.println("After creating Initable ref");
        // Does not trigger initialization
        System.out.println(Initable.staticFinal);
        // Does trigger initialization
        System.out.println(Initable.getStaticFinal2);
        // Does trigger initialization
        System.out.println(Initable2.staticNonFinal);

        Class initable3 = Class.forName("typeinfo.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);

    }

}

