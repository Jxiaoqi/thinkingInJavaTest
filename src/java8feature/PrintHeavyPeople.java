package java8feature;

public class PrintHeavyPeople implements PrintApplePredicate {

    @Override
    public boolean test (AppplesFilter.Apple apple) {
        return apple.getWeight() > 150;
    }
}
