package holding;

import java.util.ArrayList;

class Apple {
	private static long counter;
	private final long id = counter++;
	public long id() { return id;}
}

class Orange {}

public class ApplesAndOranagesWithoutGenerics {
	@SuppressWarnings({ "unchecked", "rawtypes" })		//Jave SE5 注解,表示只有有关"不受检查的异常"的警告信息应该被抑制.
	public static void main(String[] args) {
		ArrayList apples = new ArrayList();
		for (int i = 0; i < 3; i++) {
			apples.add(new Apple());
		}
		
		apples.add(new Orange());
		for (int i = 0; i < apples.size(); i++) {
			((Apple)apples.get(i)).id();
		}
		
		/**
		 * Exception in thread "main" java.lang.ClassCastException: holding.Orange cannot be cast to holding.Apple
	at holding.ApplesAndOranagesWithoutGenerics.main(ApplesAndOranagesWithoutGenerics.java:23)
		 */
		
	}
}
