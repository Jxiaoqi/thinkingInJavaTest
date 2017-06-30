package inerclasses;

import static util.Print.*;

/**
 * 内部类可以被覆盖吗?  ---明确地继承某个内部类
 * 		1.BigEgg2.Yolk明确地继承了Egg2.Yolk此内部类,并且覆盖了其中的方法.
 * insertYolk()方法允许BigEgg2将它自己的Yolk对象向上转型为Egg2中的引用y.
 * @author admin
 *
 */
class Egg2 {
	protected class Yolk {
		public Yolk() {
			print("Egg2.Yolk()");
		}
		public void f() {print("Egg2.f()");}
	}
	private Yolk y = new Yolk();
	public Egg2() { print("new Egg2()");}
	public void insertYolk(Yolk yy) { y = yy; }
	public void g() { y.f();}
}

public class BigEgg2 extends Egg2 {
	public class Yolk extends Egg2.Yolk {
		public Yolk() {
			print("BigEgg2.Yolk()");
		}
		public void f() {
			print("BigEgg2.Yolk.f()");
		}
	}
	public BigEgg2() {
		insertYolk(new Yolk());
	}
	
	public static void main(String[] args) {
		Egg2 e2 = new BigEgg2();
		e2.g();
		
		/**
		 * Egg2.Yolk()		执行顺序:  1.初始化父类的成员变量(在构造器前边),调用内部类的构造方法.
			new Egg2()				 2.父类的构造方法.
			Egg2.Yolk() 			 3.子类的构造方法(创建一个内部类)
			BigEgg2.Yolk()			 4.调用内部类的父类的构造器
			BigEgg2.Yolk.f()         5.调用内部类子类的构造器
                                     6.调用该方法(子类内部类覆盖后的)
		 */
	}
	
	
}
