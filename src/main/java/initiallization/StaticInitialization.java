package initiallization;

import static util.Print.*;

class Bowl{
	Bowl(int marker) {
		print("Bowl("+ marker +")");
	}
	void f1(int marker){
		print("f1("+ marker +")");
	}
}

class Table{
	static Bowl bowl1 = new Bowl(1);
	Table(){
		print("Table()");
		bowl2.f1(1);
	}
	void f2(int marker){
		print("f2("+ marker +")");
	}
	static Bowl bowl2 = new Bowl(2);
	
}

class Cupboard{
	Bowl bowl3 = new Bowl(3);
	static Bowl bowl4 = new Bowl(4);
	
	Cupboard() {
		print("Cupboard()");
		bowl4.f1(2);
	}
	
	void f3(int marker){
		print("f3("+ marker +")");
	}
	
	static Bowl bowl5 = new Bowl(5);
}
/**
 * 静态数据的初始化
 * 1.无论创建了多少个对象,静态数据都只占有一份存储区域.
 * 2. static 关键字不能应用于局部变量,因此,只能左右于 域(成员变量,  方法)
 * 3. 类初始化的过程:   1. 静态变量(包括静态成员变量(对象和基本数据类型))  2.非静态变量(对象和基本数据类型,按顺序执行) 3.构造方法(构造方法是隐式的静态方法)
 * 
 * 对象的创建过程:(以Dog类为例)
 * 		1.当类的静态方法/静态域  首次被访问时,  java解释器必须查找类路径,定位到Dog.class文件
 * 		2.然后载入class文件,有关静态初始化的所有动作都会执行(静态成员变量),静态初始化只在 class对象首次加载的时候进行一次.
 * 		3.当用new Dog()创建对象的时候,首先将在堆上为 Dog对象分配足够的存储空间.
 * 		4.很快,这块存储空间会被请零,这自动地讲Dog对象中的所有基本数据类型数据都设置成了默认值,而引用则被设置成了null
 * 		5.执行所有出现于字段定义出的初始化动作( 成员变量)
 * 		6.执行构造器
 * @author admin
 *
 */
public class StaticInitialization {
	public static void main(String[] args) {
		print("Creating new Cupboard() in main");
		new Cupboard();
		print("Creating new Cupboard() in main");
		new Cupboard();
		table.f2(1);
		cupboard.f3(1);
	}
	
	static Table table = new Table();
	static Cupboard cupboard = new Cupboard();
	
}
