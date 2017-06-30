package holding;

import java.util.ArrayList;

/**
 * 392
 * 泛型和类型安全的容器
 * 		1.当你制定了某个类型作为泛型参数时,你并不仅限于只能将该确切类型的对象放置到容器中.
 * 向上转型也可以像作用于其他类型一样作用于泛型.
 * 		2.程序中的输出是从Object默认的toString()方法产生的,该方法打印
 * 			类名+该对象的散列码的无符号十六进制表示(该散列码是通过hashCode()方法产生的)
 * @author admin
 *
 */
class GrannySmith extends Apple {}
class Gala extends Apple {}
class Fuji extends Apple {}
class Braeburn extends Apple {}

public class GenericsAndUpcasting {
	public static void main(String[] args) {
		ArrayList<Apple> apples = new ArrayList<Apple>();
		apples.add(new GrannySmith());
		apples.add(new Gala());
		apples.add(new Fuji());
		apples.add(new Braeburn());
		for (Apple apple : apples) {
			System.out.println(apple);
		}
		
		/**
		 * holding.GrannySmith@2e739136
holding.Gala@2542880d
holding.Fuji@32f22097
holding.Braeburn@3639b3a2
		 */
	}
}
