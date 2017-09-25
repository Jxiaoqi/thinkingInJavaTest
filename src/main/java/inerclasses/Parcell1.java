package inerclasses;

/**
 * 创建内部类:
 * 		1.内部类是一中隐藏和组织代码的一中模式.
 * @author admin
 *
 */
public class Parcell1 {
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
	
	public void ship(String dest) {
		Contents c = new Contents();
		Destination d = new Destination(dest);
		System.out.println(d.readLabel());
	}
	
	public static void main(String[] args) {
		Parcell1 p = new Parcell1();
		p.ship("Tasmania");
		
		//Tasmania
	}
	
}
