package inerclasses;

/**
 * 嵌套类(静态内部类)
 * 		1.嵌套类:	如果不需要内部类对象与外围对象之间又联系,那么可以将内部类声明为static,
 * 这通常叫做嵌套类.
 * 		2.普通的内部类对象隐式地保存了一个引用,指向创建它的外围类对象,然而,当内部类时static时,
 * 就不是这样了,嵌套类意味着:
 * 			1.要创建嵌套类的对象,并不需要其外围类的对象.
 * 			2.不能从嵌套类的对象中访问非静态的外围类对象.
 * 			3.普通内部类的对象和方法,只能放在类的外部层次上,所以普通的内部类不能有staic数据和static字段,
 * 		也不能包含嵌套类.但是嵌套类可以包含所有这些东西.
 * @author admin
 *
 */
//nested class(static inner class)
public class Parcel11 {
	
	private static class ParcelContents implements Contents {
		private int i = 11;
		@Override
		public int value() {
			return i;
		}
	}
	
	protected static  class ParcelDestination 
								implements Destination {
		
		private String label;
		
		public ParcelDestination(String whereto) {
			label = whereto;
		}
		
		@Override
		public String readLabel() {
			// TODO Auto-generated method stub
			return null;
		}
		
		//nested class can contain other static elements
		public static void f() {}
		static int x = 10;
		static class AnotherLevel {
			public static void f() {}
			static int x = 10;
		}
		
		
	}
	
	public static Destination destination(String whereto) {
		return new ParcelDestination(whereto);
	}
	
	public static Contents contents() {
		return new ParcelContents();
	}
	
	public static void main(String[] args) {
		Contents c = contents();
		Destination d = destination("Tasmina");
	}
}
