package java8feature;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * 3.8.1 比较器复合
 */
public class ComparatorRecombination {

    public static void main (String[] args) {

        List<Apple> inventory = Arrays.asList(new Apple(150, "green"),
                new Apple(120, "red"),
                new Apple(120, "green"),
                new Apple(130,"red"),
                new Apple(140,"orange"));
        //可以用静态方法Comparator.comparing,根据提取用户比较的键值的Function来返回一个Comparator
        Comparator<Apple> c = comparing(Apple::getWeight);
        inventory.sort(c);
        System.out.println(inventory);

        //1.逆序 如果你想要按苹果重量倒叙怎么办？ 用不着去建立另一个Comparator的实例。接口有一个默认方法
        // revsered可以使给定的比较器逆序。因为仍然可以用开始的那个比较器。
        inventory.sort(comparing(Apple::getWeight).reversed());
        System.out.println(inventory);

        // 2. 比较器链  如果发现有两个苹果一样重怎么办？哪个苹果排在前边？你可能需要再提供一个Comparator来进一步
        //定义这个比较。thenComparing方法就是做这个用的。它接受一个函数作为参数（就像comparing一样），如果两个
        //对象用第一个Comparator比较之后是一样的，就提供第二个Comparator.
        inventory.sort(comparing(Apple::getWeight)
                .reversed()
                .thenComparing(Apple::getColor));
        System.out.println(inventory);

    }

}
