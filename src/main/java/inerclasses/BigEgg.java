package inerclasses;

/**
 * p382
 * 内部类可以被覆盖吗?
 * 		1.如果 创建了一个内部类,然后继承其外部类,然后重新定义其内部类时,会发生什么呢?
 * 也就是说,内部类可以被覆盖吗?这看起来似乎是一个很有用的思想,但是"覆盖"内部类好像它是外围类
 * 的一个方法,其实他并不起作用. 
 * 		2.默认的构造器时编译器自动生成的,这里是调用基类的默认构造器.你可能认为既然创建了BigEgg
 * 的对象,那么所使用的应该是"覆盖后"的Yolk版本.但从输出结果并不是这样./
 * 		3.当继承了某个外围类的时候,内部类并没有发生什么特别神奇的变化.这两个内部类是完全独立的两个
 * 个体,各自在自己的命名空间内.当然明确地继承某个内部类也是可以的,见: BigEgg2.java
 * @author admin
 *
 */
class Egg {
	private Yolk y;
	protected class Yolk {
		public Yolk() {
			System.out.println("Egg.Yolk()");
		}
	}
	
	public Egg() {
		System.out.println("new Egg()");
		y = new Yolk();
	}
}

public class BigEgg extends Egg{
	public class Yolk {
		public Yolk() {
			System.out.println("BigEgg.Yolk()");
		}
	}
	public static void main(String[] args) {
		new BigEgg();
		
		/**
		 * new Egg()
			Egg.Yolk()
		 */
	}
}
