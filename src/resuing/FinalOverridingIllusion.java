package resuing;

/**
 * final 和 private关键字
 *  1.类中所有的private 方法都隐式地指定为是final的. 由于无法取用private方法,所以也就无法覆盖它.
 *  可以给private方法添加final修饰词,但这并不能给该方法增加任何额外的意义
 * @author admin
 *
 */
class WithFinals {
	private final void f() {
		System.out.println("WithFinals.f()");
	}
	private void g() {
		System.out.println("WithFinals.g()");
	}
}

class OverridingPrivate extends WithFinals {
	private final void f() {
		System.out.println("OverringPrivate.f()");
	}
	private void g() {
		System.out.println("OverringPrivate.g()");
	}
}

class OverridingPrivate2 extends OverridingPrivate {
	public final void f() {
		System.out.println("OverridingPrivate2.f()");
	}
	public void g() {
		System.out.println("OverridingPrivate2.g()");
	}
}

public class FinalOverridingIllusion {
	public static void main(String[] args) {
		OverridingPrivate2 op2 = new OverridingPrivate2();
		op2.f();
		op2.g();
		//you can upcast
		OverridingPrivate op = op2;
		//!op.g();
		//!op.f();
		WithFinals wf = op2;
		//!wf.f();
		//!wf.g();
		
		/**
		 * OverridingPrivate2.f()
			OverridingPrivate2.g()
		 */
	}
}
