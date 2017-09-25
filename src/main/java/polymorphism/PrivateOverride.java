package polymorphism;

import static util.Print.*;

/**
 * 多态的缺陷: "覆盖"私有方法
 * 	 1.我们所期望的是输出public f(),,但是private方法自动被认为是final的,而且对导出类是屏蔽的,
 * 因此,在这种情况下,Derived类中的f()方法就是一个全新的方法.既然基类中的f()方法在子类Derived中
 * 不可见.
 *   2.结论: 只有非private方法才可以被覆盖:但是还需要密切关注覆盖 private方法的现象,虽然编译器不会报错,
 * 但是也不会按照我们所期望的来执行.确切地说,在导出类中,对于基类中的private方法,最好采用不同的名字.
 * @author admin
 *
 */
public class PrivateOverride {
	private void f() {
		print("private f()");
	}
	
	public static void main(String[] args) {
		PrivateOverride po = new PrivateOverride();
		po.f();
	}
	
	//private f()
}

class Derived extends PrivateOverride {
	public void f() {
		print("public f()");
	}
}
