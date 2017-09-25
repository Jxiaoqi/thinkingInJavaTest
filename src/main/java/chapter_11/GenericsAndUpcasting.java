package chapter_11;

import java.util.ArrayList;
import java.util.List;
/**
 * 演示了: 泛型类型作为向上转型的应用. 向上转型也可以像作用于其他类型一样作用于泛型
 * @author admin
 *
 */
public class GenericsAndUpcasting {

	public static void main(String[] args) {
		List<Apple> apples = new ArrayList<Apple>();
			apples.add(new GrannySmith());
			apples.add(new Gals());
			apples.add(new Braeburn());
			apples.add(new Fuji());
			
		for (Apple apple : apples) {
			System.out.println(apple);
		}
	}
}

class GrannySmith extends Apple{
	
}

class Gals extends Apple{
	
}

class Fuji extends Apple{
	
}

class Braeburn extends Apple{
	
}