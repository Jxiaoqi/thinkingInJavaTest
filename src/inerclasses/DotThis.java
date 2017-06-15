package inerclasses;

/**
 * 使用.this 引用外部类
 * 		如果你需要生成对外部类对象的引用,可以使用外部类的名字后面紧跟.this.
 * 这样产生的引用自动地具有正确的类型,这一点在编译器就被知晓并受到检查,因为没有任何
 * 运行时开销.
 * @author admin
 *
 */
public class DotThis {
	void f() { System.out.println("DotThis.f()"); }
	
	public class Inner {
		public DotThis outer() {
			return DotThis.this;
		}
	}
	
	public Inner inner() {
		return new Inner();
	}
	
	public static void main(String[] args) {
		DotThis dt = new DotThis();
		DotThis.Inner inner = dt.inner();
		inner.outer().f();
		
		//DotThis.f()
	}
}

