package resuing;


/**
 *  final 参数
 *  1.Java 允许在参数列表中以声明的方式将参数指明为null.这指明你无法再方法中更改参数引用所指向的对象.
 *  2.基本类型被指明为final时所出现的结构:   你可以读参数,但却无法修改参数.  这一特性主要用来向匿名内部类
 *  传递数据.
 * @author admin
 *
 */

class Gizmo {
	public void spin() {}
}

public class FinalArgument {
	void with(final Gizmo g) {
		//! g = new Gizmo();  //Illegal  -- g is final
	}
	void without(Gizmo g) {
		g = new Gizmo();     // OK -- g not final
		g.spin();
	}
	void f(final int i) { 
		//i++;      		//can't change
	}
	
	int g(final int i) {
		return i+1;			//you can only read from a final primitive
	}
	
	public static void main(String[] args) {
		FinalArgument bs = new FinalArgument();
		bs.with(null);
		bs.without(null);
	}
}
