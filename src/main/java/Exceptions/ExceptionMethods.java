package Exceptions;

import static util.Print.*;

/**
 * 抛出所有异常  p457
 * 		1.可以只写一个异常处理程序来捕获所有类型的异常。通过捕获异常类型的基类Exception,
 *  就可以做到这一点。
 *  	2.因为Exception是与编程有关的所有异常的基类，所以它不会含有太多具体的信息。不过可以
 *  调用它从基类Throwable继承的方法:
 *  		String getMessage();
 *  		String getLocalizedMessage();
 *  	用来获取详细信息，或用本地语言表示的详细信息。
 *  		String toString();
 *  	返回对Throwable的简单描述，要是有详细信息，也会把它包含在内 。
 *  		void printStackTrace();
 *  		void printStackTrace(PrintStream)
 *  		void printStackTrace(java.io.PrintWriter)
 *  	打印Throwable 和 Throwable 的调用栈轨迹。调用栈显示了“把你带到异常抛出地点”的方法调用
 *  序列。其中第一个版本输出到标准错误，后两个版本允许选择要输出的流。
 *  		Throwable fillInStackTrace()
 *  	用于在 Throwable对象的内部记录栈帧的当前状态。这在程序重新抛出错误或异常时很有用。
 *  	此外： 也可以使用Throwable从基类Object继承的方法。对于异常来说getClass()也许是个很好用的方法，
 *  它将返回一个表示此对象类型的对象。然后可以使用getName()方法查询这个Class对象包含包信息的名称，或者使用
 *  支产生类 名的getSimpleName()方法。
 * @author 贾玉豪
 *
 */
public class ExceptionMethods {
	public static void main(String[] args) {
		try {
			throw new Exception("My Exception");
		} catch (Exception e) {
			// TODO: handle exception
			print("Caught Exception");
			print("getMessage(): " + e.getMessage());
			print("getLocalizedMessage: " + 
							e.getLocalizedMessage());
			print("toString(): " + e.toString());
			print("printStackTrace(): ");
			e.printStackTrace(System.out);
			
			/**
			 * Caught Exception
				getMessage(): My Exception
				getLocalizedMessage: My Exception
				toString(): java.lang.Exception: My Exception
				printStackTrace(): 
				java.lang.Exception: My Exception
					at Exceptions.ExceptionMethods.main(ExceptionMethods.java:8)
			 */
		}
	}
}
