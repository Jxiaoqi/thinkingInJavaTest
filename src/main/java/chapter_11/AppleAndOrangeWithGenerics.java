package chapter_11;

import java.util.ArrayList;
import java.util.List;

/**
 * 演示了带有泛型的容器类.以及带有泛型的容器可以用foreach循环遍历.
 * @author admin
 *
 */
public class AppleAndOrangeWithGenerics {

	public static void main(String[] args) {
		
		List<Apple> apples = new ArrayList<Apple>();
		for (int i = 0; i < 3; i++) {
			apples.add(new Apple());
		}
		
		for (Apple apple : apples) {
			System.out.println(apple.id());
		}
	}
}




