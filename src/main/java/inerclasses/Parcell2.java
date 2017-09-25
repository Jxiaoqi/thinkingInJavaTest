package inerclasses;

/**
 * 创建内部类
 * 		1.更典型的情况: 外部类将有一个方法,该方法返回一个指向内部类的引用,就像to(),contents()
 * 方法中看到的那样.
 * 		2.如果想从外部类的   非静态   方法之外的任意位置创建某个内部类的对象,那么必须像在 main()方法中那样,
 * 具体地指明这个对象的类型:  OuterClassName.InnerClassName
 * @author admin
 *
 */
public class Parcell2 {
	class Contents {
		private int i =11;
		public int value() { return i;}
	}
	
	class Destination {
		private String label;
		public Destination(String whereto) {
			label = whereto;
		}
		String readLabel() { return label;}
	}
	
	public Destination to(String s) {
		return new Destination(s);
	}
	
	public Contents contents() {
		return new Contents();
	}
	
	public void ship(String dest) {
		Contents c = new Contents();
		Destination d = new Destination(dest);
		System.out.println(d.readLabel());
	}
	
	public static void main(String[] args) {
		Parcell2 p = new Parcell2();
		p.ship("Tasmania");
		
		Parcell2 q = new Parcell2();
		Parcell2.Contents c = q.contents();
		Parcell2.Destination d = q.to("Borneo");
		System.out.println(d.readLabel());
		
		/**
		 * Tasmania
			Borneo
		 */
	}
}
