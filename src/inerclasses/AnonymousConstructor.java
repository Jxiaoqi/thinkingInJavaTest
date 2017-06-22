package inerclasses;

/**
 * 匿名内部类---通过实例初始化实现构造(匿名类不能有构造方法)
 * 		1.在匿名内部类中,如果想做一些类似构造器的行为,该怎么办呢?
 * 			在匿名类中不可能有命名构造器,但通过实例初始化,就能够达到为匿名内部类创建一个构造器的效果. 
 * 		2.在此例中,不要求变量i一定是final的.因为i被传递给匿名类的基类的构造器,它并不会在匿名内部类
 * 		内部被直接使用.
 * 
 * http://www.cnblogs.com/crt-share/archive/2015/08/29/4769331.html
 * @author admin
 *
 */
abstract class Base {
	public Base(int i) {
		System.out.println("Base constructor, i + " + i);
	}
	
	public abstract void f();
}

public class AnonymousConstructor {
	public static Base getBase(int i) {
		return new Base(i) {
			{ System.out.println("Inside instance initializer");}
			@Override
			public void f() {
				System.out.println("In anonymous f()");
			}
		};
	}
	
	public static void main(String[] args) {
		Base base = getBase(10);
		base.f();
		
		/**
		 * Base constructor, i + 10
Inside instance initializer
In anonymous f()

		 */
	}
}
