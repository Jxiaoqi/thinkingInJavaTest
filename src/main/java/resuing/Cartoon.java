package resuing;

/**
 * 初始化基类( 不带参数的构造方法,默认的构造方法)
 * 		java 会自动在导出类的构造器中插入对积累构造器的调用.
 * 		构造器是从基类"向外"扩散的,所以,基类在导出类构造器可以访问它之前就已经完成了初始化.
 * 		即使不为Cartoon()创建构造器,编译器也会为你合成一个默认的构造器,该构造器将调用基类的构造器.
 * @author admin
 *
 */
class Art{
	public Art() {
		System.out.println("Art Constructor");
	}
}

class Drawing extends Art{
	public Drawing() {
		System.out.println("Drawing Constructor");
	}
}

public class Cartoon extends Drawing{
	public Cartoon() {
		System.out.println("Cartoom Contructor");
	}
	
	public static void main(String[] args) {
		Cartoon c = new Cartoon();
		
		/**
		 * Art Constructor
			Drawing Constructor
			Cartoom Contructor
		 */
	}
}
