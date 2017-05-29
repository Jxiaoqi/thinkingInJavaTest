package initiallization;

import static util.Print.*;

class Cup {
	Cup(int marker) {
		print("Cup("+ marker +")");
	}
	
	void f(int marker) {
		print("f("+ marker +")");
	}
}

class Cups {
	static Cup cup1;
	static Cup cup2;
	static {
		cup1 = new Cup(1);
		cup2 = new Cup(2);
	}
	public Cups() {
		print("cups()");
	}
}

/**
 * 显式的静态初始化
 * 静态初始化动作(静态属性,静态代码块)仅仅执行一次 :
 * 		当首次生成这个类的一个对象,或者首次访问属于那个类的静态数据成员时.
 *   (1)和(2)的执行结构一样
 * @author admin
 *
 */
public class ExplicitStatic {
	public static void main(String[] args) {
		print("inside main");
		//Cups.cup1.f(99);  //(1)
		
		/**
		 * inside main
			Cup(1)
			Cup(2)
			f(99)
		 */
	}
	
	static Cups cups1 = new Cups();  //(2)
	static Cups cups2 = new Cups();  //(2)
}
