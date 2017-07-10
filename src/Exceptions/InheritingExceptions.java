package Exceptions;

/**
 * 创建自定义异常   p449
 * 		1.要自己定义异常类,必须从已有的异常类继承.最好是选择意思相近的异常类继承.
 * 	建立新的异常类型最简单的方法就是让编译器为你产生默认构造器.在本例中,编译器创建了
 *  默认构造器,它将自动调用基类的默认构造器.
 * @author admin
 *
 */
public class InheritingExceptions extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void f() throws SimpleExction {
		System.out.println("Throw SimpleException from f()");
		throw new SimpleExction();
	}
	
	public static void main(String[] args) {
		InheritingExceptions sed = new InheritingExceptions();
		try {
			sed.f();
		} catch (SimpleExction e) {
			System.out.println("Caught it!");
		}
		
		/**
		 * Throw SimpleException from f()
			Caught it!
		 */
	}
	
}

class SimpleExction extends Exception { }
