package inerclasses;

/**
 * 使用.this和.new
 * 		在拥有外部对象之前是不可能创建内部类对象的.这是因为内部类对象暗暗地连接到创建他的
 * 外部类对象上.但是,如果你创建的是嵌套类(静态内部类),那么它就不需要对外部对象的引用.
 * @author admin
 *
 */
public class Parcel3 {
	class Contents {
		private int i = 11;
		public int value() {
			return i;
		}
	}
	
	class Destination {
		private String label;
		public Destination(String whereto) {
			label = whereto;
		}
		String readLabel() {
			return label;
		}
	}
	
	public static void main(String[] args) {
		Parcel3 p = new Parcel3();
		Parcel3.Contents c = p.new Contents();
		Parcel3.Destination d = p.new Destination("Tasminia");
	}
	
	
	
}
