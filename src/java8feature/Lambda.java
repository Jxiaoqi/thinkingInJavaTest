package java8feature;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Java8新特性1
 * Lambda表达式与Functional接口
 */
public class Lambda {

    public static void main(String[] args) {

        /**
         * 1.一个lambda可以由用逗号分隔的参数列表、–>符号与函数体三部分表示。例如：
         */
        Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e));

        /**
         * 请注意参数e的类型是由编译器推测出来的。同时，你也可以通过把参数类型与参数包括在括号中的形式直接给出参数的类型：
         */
        Arrays.asList("d", "e", "f").forEach( (String e) -> System.out.println(e));
        /**
         * 在某些情况下lambda的函数体会更加复杂，这时可以把函数体放到在一对花括号中，就像在Java中定义普通函数一样。例如
         */
        Arrays.asList("g", "h", "i").forEach( e -> {
            System.out.println(e);
            System.out.println(e);
        });

//        String separator = ",";
//        Arrays.asList("a", "b", "c").forEach((String e) -> {
//            System.out.println(e + separator);
//            separator = "2";
//        }
//        );
        /**
         * Lambda可以引用类的成员变量与局部变量（如果这些变量不是final的话，它们会被隐含的转为final，这样效率更高）。
         *  例如，下面两个代码片段是等价的,以上代码，在Lambda里修改成员或局部变量会报错，final不可修改。
         */
        String separator = ",";
        Arrays.asList("a", "b", "c").forEach((String e) ->
                    System.out.println(e + separator)
        );

        final String final_separator = ",";
        Arrays.asList("a", "b", "c").forEach((String e ) -> System.out.println(e + final_separator));

        //Lambda用在替代匿名内部类
        /**
         * Lambda可能会返回一个值。返回值的类型也是由编译器推测出来的。如果lambda的函数体只有一行的话，那么没有必要显式使用return语句。下面两个代码片段是等价的：
         */
        System.out.println("sort:");
        List<String> sortList = Arrays.asList("b", "a", "e");
        sortList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(sortList.toString());

        System.out.println("Lambda sort");
        List<String> sortList1 = Arrays.asList("b", "a", "e");
        sortList1.sort((e1, e2) -> e1.compareTo(e2));
        System.out.println(sortList1);

        sortList1.sort((e1, e2) -> {
            int result = e1.compareTo(e2);
            return result;
        });
        System.out.println(sortList1);



    }

}
