package java8feature;

/**
 * 该类对ApplePredicate动作的具体实现，来筛选重量大于150克的苹果
 */
public class AppleHeavyWeithPredicate implements ApplePredicate {


    @Override
    public boolean test (AppplesFilter.Apple apple) {
        return apple.getWeight() > 150;
    }
}
