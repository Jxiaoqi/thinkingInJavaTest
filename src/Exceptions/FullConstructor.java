package Exceptions;

/**
 * 创建自定义异常
 * 		为异常类定义一个接受字符串参数的构造器.
 * 		1.两个构造器定义了MyException类对象的创建方式.对于第二个构造器,使用
 * super关键字明确调用了其基类构造器,它接受一个字符串作为参数.
 * 		2.在异常处理程序中,调用了在Throwable类声明(Exception即从此类继承)的
 *  printStackTrace()方法.就像从输出中看到的,它将打印"从方法调用处直到异常抛出处"
 *  的方法调用序列.这里,信息被发送到了System.out,并自动地被捕获和显示在输出中.但是,
 *  如果调用默认版本:
 *  	e.printStackTrace();
 *    则将信息被输出到标准错误流.
 * @author admin
 *
 */
class MyException extends Exception {
	public MyException() {}
	public MyException(String msg) {
		super(msg);
	}
}

public class FullConstructor {
	public static void f() throws MyException {
		System.out.println("Throwing MyException from f()");
		throw new MyException();
	}
	
	public static void g() throws MyException {
		System.out.println("Throwing MyException from g()");
		throw new MyException("Originated in g()");
	}
	
	public static void main(String[] args) {
		try {
			f();
		} catch (MyException e) {
			e.printStackTrace(System.out);
		}
		
		try {
			g();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace(System.out);
		}
		
		/**
		 * Throwing MyException from f()
			Exceptions.MyException
				at Exceptions.FullConstructor.f(FullConstructor.java:13)
				at Exceptions.FullConstructor.main(FullConstructor.java:23)
		   Throwing MyException from g()
			 Exceptions.MyException: Originated in g()
				at Exceptions.FullConstructor.g(FullConstructor.java:18)
				at Exceptions.FullConstructor.main(FullConstructor.java:29)
		 */
	}
}
