package java8feature;

public class AppleSimpleFormat implements AppleFormat {

    @Override
    public String accept (AppplesFilter.Apple apple) {
        return "An apple of " + apple.getWeight() + " g";
    }
}
