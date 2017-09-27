package java8feature;

import java.util.function.Function;

/**
 * 函数复合 3.8.3
 *      可以把Function接口所代表的Lambda表达式复合起来。Function接口
 *  为此配了andThen 和 compose两个默认方法，它们都会返回Function的一个实例。
 */
public class FunctionCombination {

    public static void main (String[] args) {
        // andThen方法会返回一个函数，它先对输入应用一个给定函数，再对输出应用另一个函数。相当于 g(f(x))
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * 2;
        Function<Integer, Integer> h = f.andThen(g);
        int result = h.apply(1);
        System.out.println(result);

        //使用compose方法，先把给定的函数用作compose的参数里面给定的那个函数，然后再把函数本身作用于结果
        Function<Integer, Integer> h1 = f.compose(g);
        int result1 = h1.apply(1);
        System.out.println(result1);

        //利用Letter通过复合这些工具方法来创建各种转型流水线，比如创建一个流水线：
        //  先加上抬头，然后进行拼写检查，最后加上一个落款。
        Function<String, String> addHeader = Letter:: addHeader;
        Function<String, String> transformationPipeline =
                addHeader.andThen(Letter::checkSpelling)
                         .andThen(Letter::addFooter);
        String letter = transformationPipeline.apply("lambda");
        System.out.println(letter);

        //第二个流水可能只加抬头、落款，而不做拼写检查
        Function<String, String> addHeader1 = Letter::addHeader;
        Function<String, String> transformationPipeline1
                = addHeader1.andThen(Letter::addFooter);
        String letter1 = transformationPipeline1.apply("lambda");
        System.out.println(letter1);
    }


    /**
     * 有一系列工具方法，对用String表示的一封信做文本交换。
     */
    public static class Letter {
        public static String addHeader(String text) {
            return "From Raoul, mario and Alan: " + text;
        }

        public static String addFooter(String text) {
            return text + " Kind regards";
        }

        public static String checkSpelling(String text) {
            return text.replaceAll("labda", "lambda");
        }

    }
}
