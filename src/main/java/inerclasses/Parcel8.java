package inerclasses;

/**
 * 匿名内部类---扩展了有非默认构造器的类
 * 		1.如果你的基类需要一个有参数的构造器,应该怎么办?
 * 			只需要简单地传递合适的额参数给基类的构造器即可.尽管Wrapping只是一个具有具体
 * 		实现的普通类,但它还是被其导出类当作公共"接口"来使用.
 * @author admin
 *
 */
public class Parcel8 {
	public Wrapping wrapping(int x) {
		return new Wrapping(x) {
			@Override
			public int value() {
				// TODO Auto-generated method stub
				return super.value() * 47;
			}
		};
	}
	
	public static void main(String[] args) {
		Parcel8 p = new Parcel8();
		Wrapping w = p.wrapping(10);
	}
}
