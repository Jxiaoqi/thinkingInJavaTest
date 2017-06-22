package inerclasses;

/**
 * 在方法和作用域中的内部类
 * 		---在方法的作用域中创建一个完整的类(局部内部类);
 * 		1.PDestination类是destination()方法的一部分,而不是Parcel5的一部分.
 * 	所以,在destination()之外不能访问Destination.
 * 		2.在 destination()中定义了内部类Pdestination,并不意味着一旦dest()方法执行
 * 	完毕,PDestination就不可用了.
 * @author admin
 *
 */
public class Parcel5 {

	public Destination destination(String s) {
		class PDestination implements Destination {
			private String label;
			private PDestination(String whereto) {
				label = whereto;
			}
			@Override
			public String readLabel() {
				// TODO Auto-generated method stub
				return label;
			}
			
		}
		
		return new PDestination(s);
	} 
	
	public static void main(String[] args) {
		Parcel5 p = new Parcel5();
		Destination d = p.destination("Tasmaia");
	}
}
