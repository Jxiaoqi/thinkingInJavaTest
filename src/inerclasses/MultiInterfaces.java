package inerclasses;

/**
 * 为什么需要内部类?   
 * 		场景:  必须在一个类中以某种方式实现两个接口.由于接口的灵活性,有两种选择:  使用单一类, 或者使用内部类.
 * 		1.每个内部类都能独立地继承自一个(接口的)实现,所以无论外围类是否已经继承了某个
 * (接口)的实现,对于内部类都没有影响.
 * 		2.如果没有内部类提供的、可以继承多个具体的或抽象的类的能力，一些设计与编程问题就很难解决。
 * 从这个角度看，内部类使得多重继承的解决方案变得完整.接口解决了部分问题,而内部类有效地实现了"多重继承".
 * 也就是说,内部类允许继承多个非接口类型.(类或抽象类)
 * 		
 * @author admin
 *
 */

interface A {}
interface B {}

class X implements A, B {}

class Y implements A {
	B makeB() {
		return new B() {};
	}
}

public class MultiInterfaces {
	static void takeA(A a) {}
	static void takeB(B b) {}
	public static void main(String[] args) {
		X x = new X();
		Y y = new Y();
		takeA(x);
		takeA(y);
		
		takeB(x);
		takeB(y.makeB());
		
	}
}
