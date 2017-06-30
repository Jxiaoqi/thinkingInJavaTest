package inerclasses;


/**
 * 为什么要使用内部类?  实现多重继承.
 * 		如果拥有的是抽象的类  或 具体的类,而不是接口,那就只能使用内部类才能实现多重继承.
 * 	使用内部类,可以获得其他一些特性:
 * 		1.内部类可以有多个实例,每个实例都有自己的状态信息,并且与其外围类对象的信息相互独立.
 * 		2.在单个外围类中,看可以让多个内部类以不同的方式实现同一个接口,或继承同一个类.
 * 		3.创建内部类对象的时刻并不依赖于外围类对象的创建.
 * 		4.内部类并没有令人迷惑的"is-a"关系; 它就是一个独立的实体.
 * 	例如: 如果Sequence .java 不是用内部类,就必须声明"Sequence是一个Selector",对于
 * 某个特定的Sequence只有一个Selector.然而使用内部类很容易能拥有另一个方法reverseSelector(),
 * 用它来生成一个反方向遍历序列的Selector.只有内部类才有这种灵活性.
 * @author admin
 *
 */
class D {}
abstract class E {}

class Z extends D {
	E makeE() {
		return new E() {};
	}
}

public class MultiImplimentation {
	static void takesD(D d) {}
	static void takesE(E e) {}
	public static void main(String[] args) {
		Z z = new Z();
		takesD(z);
		takesE(z.makeE());
	}
}
