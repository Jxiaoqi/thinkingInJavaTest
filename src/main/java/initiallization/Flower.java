package initiallization;

import static util.Print.*;
/**
 * 1.构造方法中this关键字的使用
 * 2.在一个构造器中调用另一个构造器.
 * 3.构造器只能在一个构造器中调用,不能再非构造器的任何别的方法中调用.否则,编译器会报错.
 * @author admin
 *
 */
public class Flower {
	
	int petalCount = 0;
	String s = "initial value";
	Flower(int petals) {
		petalCount = petals;
		print("Constructor w/ int arg only, petalCount= " + petalCount);
	}
	
	Flower(String ss) {
		print("Constuctor w/ string arg only, s = " + ss);
		s = ss;
	}
	
	Flower(String s, int petals){
		this(petals);			//1.尽管可以用this调用构造器,但却不能调用两个构造器   2.必须将构造器调用置于最起始处,否则编译器将报错
		//this(s);				//Constructor call must be the first statement in a constructor
		this.s = s;				//由于参数的名称和 成员变量的名称相同,为了避免歧义,所有,用this.s来代表成员变量
		print("String & int args");
	}
	
	Flower() {
		this("hi",47);
		print("default constructor (no args)");
	}
	
	void printPetalCount(){
		//this(11);				//Constructor call must be the first statement in a constructor  
								//除了构造器以外,编译器禁止在任何其他方法中调用构造器
		print("petalCount = " + petalCount + " s = " + s);
	}
	
	public static void main(String[] args) {
		Flower flower = new Flower();
		flower.printPetalCount();
		
		/**
		 * Constructor w/ int arg only, petalCount= 47
		   String & int args
		   default constructor (no args)
		   petalCount = 47s = hi

		 */
	}
	
	
}
