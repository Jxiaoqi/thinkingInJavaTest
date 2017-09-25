package Exceptions;

/**
 * 重新抛出异常 p461
 * 		调用fillInStackTrace()的哪一行就成了异常的新发生地了.
 * @author admin
 *
 */
public class Rethrowing {
	public static void f() throws Exception {
		System.out.println("originating the exception in f()");
		throw new Exception("throwing from f()");
	}
	
	public static void g() throws Exception {
		try {
			f();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Inside g(), e.printStackTrace()");
			e.printStackTrace(System.out);
			throw e;
		}
	}
	
	public static void h() throws Exception {
		try {
			f();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Inside h(), e.printStackTrace()");
			e.printStackTrace(System.out);
			throw (Exception)e.fillInStackTrace();
		}
	}
	
	public static void main(String[] args) {
		try {
			g();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("main: printStackTrace()");
			e.printStackTrace(System.out);
		}
		
		try {
			h();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("main: printStackTrace()");
			e.printStackTrace(System.out);
		}
		
		/**
		 * 
originating the exception in f()
Inside g(), e.printStackTrace()
java.lang.Exception: throwing from f()
	at Exceptions.Rethrowing.f(Rethrowing.java:6)
	at Exceptions.Rethrowing.g(Rethrowing.java:11)
	at Exceptions.Rethrowing.main(Rethrowing.java:33)
main: printStackTrace()
java.lang.Exception: throwing from f()
	at Exceptions.Rethrowing.f(Rethrowing.java:6)
	at Exceptions.Rethrowing.g(Rethrowing.java:11)
	at Exceptions.Rethrowing.main(Rethrowing.java:33)
originating the exception in f()
Inside h(), e.printStackTrace()
java.lang.Exception: throwing from f()
	at Exceptions.Rethrowing.f(Rethrowing.java:6)
	at Exceptions.Rethrowing.h(Rethrowing.java:22)
	at Exceptions.Rethrowing.main(Rethrowing.java:41)
main: printStackTrace()
java.lang.Exception: throwing from f()
	at Exceptions.Rethrowing.h(Rethrowing.java:27)
	at Exceptions.Rethrowing.main(Rethrowing.java:41)
		 */
	}
}
