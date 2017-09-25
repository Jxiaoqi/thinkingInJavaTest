package inerclasses;

/**
 * 匿名内部类----在匿名内部类中定义字段时,还能够对其执行初始化操作.
 * 		1.如果定义一个匿名内部类,并且希望它使用一个在其外部定义的对象,那么编译器会要求其
 * 参数引用时final的.如果你忘记了, 就会收到编译时错误消息.
 * @author admin
 *
 */
public class Parcel9 {
	
	public Destination destination(final String dest) {
		return new Destination() {	//String cannot be resolved to a variable
			private String label = dest;	//Cannot refer to a non-final variable dest inside an inner class defined in a different method
			@Override
			public String readLabel() {
				// TODO Auto-generated method stub
				return label;
			}
		};
	}
	
	public static void main(String[] args) {
		Parcel9 p = new Parcel9();
		Destination d = p.destination("dest");
	}

}
