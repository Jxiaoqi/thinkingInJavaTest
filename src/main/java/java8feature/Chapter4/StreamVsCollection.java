package java8feature.Chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 流只能被消费一次（遍历一次）
 */
public class StreamVsCollection {

    public static void main (String[] args) {
        List<String> names = Arrays.asList("Java8", "Lambdas", "In", "Action");
        Stream<String> s = names.stream();
        s.forEach(System.out :: println);
        /**
         * Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
         at java.util.stream.AbstractPipeline.sourceStageSpliterator(AbstractPipeline.java:279)
         at java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:580)
         at java8feature.Chapter4.StreamVsCollection.main(StreamVsCollection.java:13)
         */
        //s.forEach(System.out :: println);



    }
}
