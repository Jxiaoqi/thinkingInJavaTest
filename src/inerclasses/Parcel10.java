package inerclasses;

/**
 * 匿名内部类----实例初始化实现构造
 * 		1.在实例初始化的内部,可以看到有一段代码,它们不能作为字段初始化的一部分执行(就是if语句).
 * 所以,对于匿名内部类而言,实例初始化的实际效果就是构造器.当然它受到了限制-----你不能重载实例初始化方法,
 * 所以,你仅有这样一个构造器.
 * 		2.匿名内部类与正规的的继承相比有些受限,因为匿名内部类既可以扩展类,也可以实现接口,但是不能两者兼备.
 * 而且如果是实现接口,也只能实现一个接口.
 * @author admin
 *
 */
public class Parcel10 {
	
	public Destination destination(final String dest, final float price) {
		return new Destination() {
			private int cost;
			private String label = dest;
			{
				cost = Math.round(price);
				if (cost > 100) {
					System.out.println("Over budget!");
				}
			}
			@Override
			public String readLabel() {
				// TODO Auto-generated method stub
				return label;
			}
		};
	}
	
	public static void main(String[] args) {
		Parcel10 p = new Parcel10();
		Destination d = p.destination("Tasimaia", 101.382F);
		
		//Over budget!
	}
}
