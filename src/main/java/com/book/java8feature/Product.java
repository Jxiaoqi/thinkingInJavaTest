package com.book.java8feature;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;

/**
 *  * Collectors.toMap()方法的坑, value 不能为空
 *  *
 *  * @author xiaoqi
 *  * @since 10 十二月 2017
 *  
 */
@Data
public class Product {

    private String id;
    private String code;

    public Product (String id, String code) {
        this.id = id;
        this.code = code;
    }

    public static void main (String[] args) {

        Product p = new Product("1", "a");
        Product p1 = new Product("2", "b");
        Product p2 = new Product("3", "c");
        Product p3 = new Product("4", null);

        List<Product> list = new ArrayList() {
            {
                add(p);
                add(p1);
                add(p2);
                add(p3);
            }
        };

        /**
         * Exception in thread "main" java.lang.NullPointerException
         at java.util.HashMap.merge(HashMap.java:1224)
         at java.util.stream.Collectors.lambda$toMap$58(Collectors.java:1320)
         at java.util.stream.ReduceOps$3ReducingSink.accept(ReduceOps.java:169)
         at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1374)
         at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:481)
         at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:471)
         at java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:708)
         at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
         at java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:499)
         at access.Product.main(Product.java:48)

         */
        list.stream().collect(Collectors.toMap(Product::getId, Product::getCode));

        list.stream().filter(product -> product.getCode() != null).collect(Collectors.toMap(Product::getId, Product::getCode));
    }
}
