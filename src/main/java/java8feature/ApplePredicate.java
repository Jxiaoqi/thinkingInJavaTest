package java8feature;


/**
 * 筛选苹果动作的建模，谓词，提供了统一的方法，来判断该苹果是否符合条件
 */
public interface ApplePredicate {

    boolean test(AppplesFilter.Apple apple);
}
