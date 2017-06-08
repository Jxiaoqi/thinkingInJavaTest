package resuing;

import static util.Print.*;

/**
 * 初始化 及 类的加载
 *   1.每个类的编译代码都存在于他自己的独立文件中,该文件只在需要使用程序代码时才会被加载.(class 文件)
 *   2.一般来说,可以说:"类的代码在初次使用时才加载."这通常是指加载发生于创建类的第一个对象之时,但是当访问
 * static 域或static 方法时,才会发生加载.
 * 	 3.初次使用之处要是static初始化发生之处.所有的static对象和static 代码段都会在加载时依程序中的
 * 顺序(即,定义类时的书写顺序)而一次初始化.当然,定义为static 的东西只会被初始化一次.
 * 	 4. 记载和初始化的过程     :  
 * 		 1.在Bettle上运行java时,所发生的第一件事就是试图访问Bettle.main()
 * (static  方法),于是加载器可是启动并找出Bettle的编译代码(Bettle.class).在对它进行加载的过程中,
 * 编译器注意到它有一个基类(这是由关键字extends得知的),于是它继续进行加载.不管你是否打算产生一个该基类的对象.
 * 如果该基类还有其自身的基类,那么第二个基类就会被加载,如此类推.接下来,根基类中的static初始化就会执行,然后是
 * 下一个导出类.以此类推.这种方式很重要,因为导出类的static初始化可能会依赖于基类成员能够被正确初始化.(类加载完毕你)
 * 		2.类加载完毕以后,对象就可以创建了.首先,对象中所有的基本类型都会被设为默认值,对象引用设置为null(这是通过
 * 讲对象内存设为二进制零值而一举生成的).然后,基类的构造器会被调用. 基类构造器和导出类构造器一样,以相同的顺序来经历相同的过程.
 * 在基类构造器完成之后,实例变量按其次序被初始化.
 * 	5.加载和初始化的顺序:
 * 		首次访问被加载,先加载基类的class,然后是导出类class,在加载过程中,static会初始化,所有的static对象和
 *  static代码块按顺序执行.
 *  	加载完成只有,成员变量的初始化,基类中的基础数据被初始化,导出类中的基本数据类型被初始化,基类中的构造方法,导出类的构造方法.
 * 
 * @author admin
 *
 */
class Insect {
	private int i = 9;
	protected int j;
	public Insect() {
		print("i = " + i + ", j  = " + j);
		j = 39;
	}
	private static int x1 = 
			printInit("static Insect.x1 initialized");
	static int printInit(String s) {
		print(s);
		return 47;
	}
}

public class Beetle extends Insect {
	private int k = printInit("Bettle.k initialized");
	public Beetle() {
		print("k = " + k);
		print("j = " + j);
	}
	private static int x2 = 
			printInit("static Beetle.k initialized");
	public static void main(String[] args) {
		print("Beetle constructor");
		Beetle b = new Beetle();
		
		/**
		 * static Insect.x1 initialized
			static Beetle.k initialized
			Beetle constructor
			i = 9, j  = 0
			Bettle.k initialized
			k = 47
			j = 39
		 */
	}
}
