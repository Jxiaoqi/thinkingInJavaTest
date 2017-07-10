package Exceptions;

import static util.Print.*;

/**
 * 自定义异常类
 * 		覆盖了Throwable.getMessage()方法,以产生更详细的信息.
 * @author admin
 *
 */
class MyException2 extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	public MyException2() {}
	public MyException2(String msg) {
		super(msg);
	}
	public MyException2(String msg, int x) {
		super(msg);
		this.x = x;
	}
	public int val() { return x;}
	
	@Override
	public String getMessage() {
		return "Detail Message: " + x + " " + super.getMessage();
	}
}

public class ExtraFeatures {
	public static void f() throws MyException2 {
		print("Throwing MyException2 form f()");
		throw new MyException2();
	}
	
	public static void g() throws MyException2 {
		print("Throwing MyException2 form g()");
		throw new MyException2("Originated in g()");
	}
	
	public static void h() throws MyException2 {
		print("Throwing MyException2 from h()");
		throw new MyException2("Originated in h()", 47);
	}
	
	public static void main(String[] args) {
		try {
			f();
		} catch (MyException2 e) {
			// TODO: handle exception
			e.printStackTrace(System.out);
		}
		
		try {
			g();
		} catch (MyException2 e) {
			// TODO: handle exception
			e.printStackTrace(System.out);
		}
		
		try {
			h();
		} catch (MyException2 e) {
			// TODO: handle exception
			e.printStackTrace(System.out);
			System.out.println("e.val() = " + e.val());
		}
		
		/**
		 * Throwing MyException2 form f()
		   Exceptions.MyException2: Detail Message: 0 null
				at Exceptions.ExtraFeatures.f(ExtraFeatures.java:26)
				at Exceptions.ExtraFeatures.main(ExtraFeatures.java:41)
			Throwing MyException2 form g()
			Exceptions.MyException2: Detail Message: 0 Originated in g()
				at Exceptions.ExtraFeatures.g(ExtraFeatures.java:31)
				at Exceptions.ExtraFeatures.main(ExtraFeatures.java:48)
			Throwing MyException2 from h()
			Exceptions.MyException2: Detail Message: 47 Originated in h()
				at Exceptions.ExtraFeatures.h(ExtraFeatures.java:36)
				at Exceptions.ExtraFeatures.main(ExtraFeatures.java:55)
			e.val() = 47
		 */
	}
}
