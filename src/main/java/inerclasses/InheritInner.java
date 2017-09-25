package inerclasses;

/**
 * 继承内部类
 * 		1.因为内部类的构造器必须连接到指向其外围类对象的引用,所以在继承
 * 内部类的时候,事情会变得有点复杂. 问题在于, 那个指向外围类对象的"秘密的"引用必须
 * 被初始化,而在导出类中不在存在可连接的默认对象.
 * 		2. InheritInner 只继承内部类,而不是外围类.但是当要生成一个构造器时,默认的
 * 构造器并不算好,而且不能只是传递一个指向外围类对象的引用.此时,必须使用以下语法:
 *    enclosingClassReference.super();
 * 
 * @author admin
 *
 */
class WithInner {
	class Inner {}
}

public class InheritInner extends WithInner.Inner {
	
	//No enclosing instance of type WithInner is available due to some intermediate constructor invocation
	//public InheritInner() {	}
	public InheritInner(WithInner wi) {
		wi.super();
	}
	
	public static void main(String[] args) {
		WithInner wi = new WithInner();
		InheritInner in = new InheritInner(wi);
	}
}
