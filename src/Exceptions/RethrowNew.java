package Exceptions;

/**
 * 重新抛出异常  p463
 * 		有可能在捕获异常之后抛出另一种异常.这么做的话,得到的效果类似于使用
 * fillInStackTrace(),有关 原来异常发生点的信息会丢失,剩下的是与新的抛出
 * 点有关的信息:
 * 		最后那个异常仅知道自己来自main(),而对f()一无所知.
 * 		永远 ....
 * 		
 * @author admin
 *
 */
class OneException extends Exception {
	public OneException(String s) {
		super(s);
	}
}

class TwoException extends Exception {
	public TwoException(String s) {
		super(s);
	}
}

public class RethrowNew {
	public static void f() throws OneException {
		System.out.println("originating the exception in f()");
		throw new OneException("throw from f()");	
	}
	
	public static void main(String[] args) {
		try {
			try {
				f();
			} catch (OneException e) {
				System.out.println("Caught in inner try, e.printStackTrace()");
				e.printStackTrace(System.out);
				throw new TwoException("from inner try");
			}
		} catch (TwoException e) {
			// TODO: handle exception
			System.out.println(
					"Caught in outer try, e.printStackTrace()");
			e.printStackTrace(System.out);
		}
	}
}	
