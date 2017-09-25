package initiallization;

import static util.Print.*;

class Mug{
	Mug(int marker){
		print("Mug("+ marker +")");
	}
	
	void f(int marker){
		print("f("+ marker +")");
	}
}

/**
 * 非静态实例初始化
 * 	java 中也有成为实例初始化的类似用法, 用来初始化每一个对象的非静态变量
 * 	实例初始化子句,它使得你可以保证无论调用了哪个显式构造器,某些操作都会放生.
 * 	从输出可以看出,实例化子句是在两个构造方法之前执行的.
 * @author admin
 *
 */
public class Mugs {
	Mug mug1;
	Mug mug2;
	{						//实例初始化子句,看起来它与静态初始化子句一模一样,只不过少了static关键字
		mug1 = new Mug(1);
		mug2 = new Mug(2);
	}
	public Mugs() {
		print("Mugs()");
	}
	Mugs(int marker){
		print("Mugs(int)");
	}
	
	public static void main(String[] args) {
		print("Inside main()");
		new Mugs();
		print("new Mugs completed");
		new Mugs(1);
		print("new Mugs(1) completed");
		
		/**
		 * Inside main()
			Mug(1)
			Mug(2)
			Mugs()
			new Mugs completed
			Mug(1)
			Mug(2)
			Mugs(int)
			new Mugs(1) completed

		 */
	}
}
