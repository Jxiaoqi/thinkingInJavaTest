package inerclasses;

/**
 * 闭包与回调  (372)
 * 		1.闭包(closure)是一个可调用的对象,它记录了一些信息,这些信息来自于创建它的作用域.
 * 内部类是面向对象的闭包.
 * 		2.该例子展示了外围类实现一个接口与内部类实现此接口之间的区别.
 * 		3.回调的价值在于它的灵活性----可以在运行时动态地决定需要调用什么方法.
 * 		4.在Callee2中除了getCallBackReference()以外,其他成员都是private的.要想
 * 建立与外部世界的任何连接,interface Incrementable都是必需的.在这了可以看到,interface
 * 是如何允许接口与接口的实现完全独立的.
 * @author admin
 *
 */
interface Incrementable {
	void increment();
}

//very simple to just implement the interface
class Callee1 implements Incrementable {
	private int i = 0;
	@Override
	public void increment() {
		i++;
		System.out.println(i);
	}
	
}

class MyIncrement {
	public void increment() { System.out.println("Other operation");}
	static void f(MyIncrement mi) { mi.increment();}
}

class Callee2 extends MyIncrement {
	private int i = 0;
	@Override
	public void increment() {
		super.increment();
		i++;
		System.out.println(i);
	}
	
	private class Closure implements Incrementable {
		
		//Specify outer-class method, otherwise
		// you'd get an infinite recursion   死循环
		@Override
		public void increment() {
			Callee2.this.increment();
		}
	}
	
	Incrementable getCallbackReference() {
		return new Closure();
	}
}

class Caller {
	private Incrementable callBackReference;
	public Caller(Incrementable cbh) {
		callBackReference = cbh;
	}
	void go() {
		callBackReference.increment();
	}
}

public class CallBacks {
	public static void main(String[] args) {
		Callee1 c1 = new Callee1();
		Callee2 c2 = new Callee2();
		MyIncrement.f(c2);
		
		Caller caller1 = new Caller(c1);
		Caller caller2 = new Caller(c2.getCallbackReference());
		caller1.go();
		caller1.go();
		caller2.go();
		caller2.go();
		caller2.go();
		
		/**
		 * 
Other operation
1
1
2
Other operation
2
Other operation
3
Other operation
4

		 */
	}
}
