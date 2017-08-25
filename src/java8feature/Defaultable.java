package java8feature;

import java.util.Collection;
import java.util.function.Supplier;

/**
 * Java 8用默认方法与静态方法这两个新概念来扩展接口的声明。默认方法使接口有点像Traits（Scala中特征(trait)类似于Java中的Interface，
 * 但它可以包含实现代码，也就是目前Java8新增的功能），但与传统的接口又有些不一样，它允许在已有的接口中添加新方法，而同时又保持了与旧版本代码的兼容性。

    默认方法与抽象方法不同之处在于抽象方法必须要求实现，但是默认方法则没有这个要求。相反，每个接口都必须提供一个所谓的默认实现，
    这样所有的接口实现者将会默认继承它（如果有必要的话，可以覆盖这个默认实现）
 */
public  interface  Defaultable {
    // Interfaces now allow default methods, the implementer may or
    // may not implement (override) them.
    default String notRequired() {
        return "Default Implementation";
    }


    public static class DefalultableImpl implements  Defaultable {

    }

    public static  class OverridableImpl implements  Defaultable {

        @Override
        public String notRequired() {
            return "Overriden implementation";
        }
    }

    public interface DefaultFactory {
        //// Interfaces now allow static methods
        static Defaultable create(Supplier<Defaultable> supplier) {
            return supplier.get();
        }
    }

    public static void main(String[] args) {
        Defaultable defaultable = DefaultFactory.create(DefalultableImpl::new);
        System.out.println(defaultable.notRequired());

        defaultable = DefaultFactory.create(OverridableImpl::new);
        System.out.println(defaultable.notRequired());

        
    }



}


