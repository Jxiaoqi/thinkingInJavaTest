package java8feature;

import java.util.function.Predicate;

/**
 * 谓词复合 Predicate
 *      谓词接口包括三个方法： negate , and  和 or, 让你可以重用已有的Predicate来
 *  创建更复杂的谓词。
 */
public class PredicateCombination {

    public static void main (String[] args) {
        //红苹果
        Predicate<Apple> redApple = apple -> "red".equals(apple.getColor()) ;
        //不是红苹果
        Predicate<Apple> notRedApple = redApple.negate();
        //一个苹果，既是红色又比较重
        Predicate<Apple> RedAndHeavyApple =
                redApple.and(apple -> apple.getWeight() > 150);
        //要嘛是重（150克以上）的红苹果，要么是绿苹果。
        Predicate<Apple> redAndHeavyAppleOrGreen =
                redApple.and(apple -> apple.getWeight() > 150)
                .or(apple -> "green".equals(apple.getColor()));
    }
}
