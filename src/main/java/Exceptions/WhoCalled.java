package Exceptions;

/**
 * 栈轨迹
 * 		printStackTrace()方法所提供的信息可以通过getStackTrace()方法来
 * 直接访问，这个方法将返回一个由栈轨迹的元素所构成的数组，其中每一个元素都表示栈中的一帧。
 * 元素0 是栈顶元素，并且是调用序列中的最后一个方法调用（这个Throwable被创建和抛出之处）。
 * 数组中的最后一个元素和栈底是调用序列中的最后一个方法调用。
 * @author 贾玉豪
 *
 */
public class WhoCalled {
	static void f() {
		// Generate an exception to fill in the stack trace
		try {
			throw new Exception();
		} catch (Exception e) {
			// TODO: handle exception
			for (StackTraceElement ste : e.getStackTrace()) {
				System.out.println(ste.getMethodName());
			}
			//e.printStackTrace(System.out);
		}
	}
	
	static void g() { f();}
	static void h() { g();}
	
	public static void main(String[] args) {
		f();
		System.out.println("------------------------");
		g();
		System.out.println("------------------------");
		h();
		
/**
 * 
f
main
------------------------
f
g
main
------------------------
f
g
h
main
 * 
 */
		
	}
}
