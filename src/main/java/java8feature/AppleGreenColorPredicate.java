package java8feature;

/**
 * 提供了对筛选苹果动作的具体实现，用来筛选绿苹果
 */
public class AppleGreenColorPredicate implements ApplePredicate {

    @Override
    public boolean test (AppplesFilter.Apple apple) {
        return apple.getColor().equals("green");
    }
}
