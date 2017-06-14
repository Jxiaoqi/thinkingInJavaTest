package interfaces.music5;

import polymorphism.music.Note;
import static util.Print.*;

/**
 * 接口
 * 		1.接口:  interface关键字使抽象的概念更进了一步.
 * 			1.1:  abstract 关键字允许人们在类中创建一个或多个没有任何定义的方法---提供了接口部分,但是
 * 没有任何相应的具体实现,这些实现由类的继承者创建的.
 * 			1.2  interface关键字产生一个完全抽象的类,它根本没有提供任何实现.它允许创建者确定方法名, 参数列表
 * 和返回值,但是没有任何方法体. 接口只提供了形式,而未提供具体实现.
 * 		2.协议: 一个接口表示:"所有实现了该特定接口的类看起来都像这样".因为,任何使用特定接口的代码都知道可以调用该接口
 * 的哪些方法.因此,接口被用来建立类与类的之间的 <  协议  >
 * 		3.多重继承  :  interface 不仅仅是一个极度抽象的类,因为它允许人们通过创建一个能够被向上转型为多重基类的类型,
 * 来实现类似多重继承变种的特性.
 * 		4.访问修饰符 : 就像类一样,可以在interface关键字前面添加public关键字(但仅限于该接口在与其同名的文件中被定义).
 * 如果不添加public 关键字,则它只具有包访问权限,这样它就只能在同一个包内使用.
 * 		5. 接口中的域  : 接口中也可以包含域,但是这些域隐式地是static 和final的.
 * 		6. 接口中的方法: 可以选择在接口中显式地讲方法声明为public的,但即使你不这么做,他们也是public 的.因此,当要实现
 * 一个接口时,在接口中的方法必须被定义为public 的.否则, 他们讲只能得到默认的包访问权限,这样在方法被继承的过程中,其可访问
 * 权限被降低了,这是java编译器所不允许的.  (子类方法的访问权限  大于等于  父类)
 * 		7. what()方法已经被修改为toString()方法,因为toString()的逻辑正是what()要实现的逻辑.由于toString()
 * 方法是根类Object的一部分,因此它不需要出现在接口中.
 * @author admin
 *
 */
interface Instrument {
	//Compile-time constant;
	int VALUE = 5;  	//static & final
	void play(Note n);		//Automatically public
	void adjust();
}

class Wind implements Instrument {

	@Override
	public void play(Note n) {
		print(this + ".play() " + n);
	}

	@Override
	public String toString() {
		return "Wind";
	}
	
	@Override
	public void adjust() {
		print(this + ".adjust()");
	}
	
}

class Percussion implements Instrument {

	@Override
	public void play(Note n) {
		print(this + ".play()" + n);
	}

	@Override
	public String toString() {
		return "Percussion";
	}
	
	@Override
	public void adjust() {
		print(this + ".adjust()");
	}
	
}

class Stringed implements Instrument {

	@Override
	public void play(Note n) {
		print(this + ".play()" + n);
	}

	@Override
	public String toString() {
		return "Stringed";
	}
	
	@Override
	public void adjust() {
		print(this + ".adjust()");
	}
	
}

class Brass extends Wind {
	@Override
	public String toString() {
		return "Brass";
	}
}

class WoodWind extends Wind {
	@Override
	public String toString() {
		return "WoodWind";
	}
}
public class Music5 {
	static void tune(Instrument i){
		i.play(Note.MIDDLE_C);
	}
	
	static void tuneAll(Instrument[] e){
		for(Instrument i : e) {
			tune(i);
		}
	}
	
	public static void main(String[] args) {
		Instrument[] orchestra = {
				new Wind(),
				new Percussion(),
				new Stringed(),
				new Brass(),
				new WoodWind()
		};
		tuneAll(orchestra);
		
		/**
		 * Wind.play() MIDDLE_C
			Percussion.play()MIDDLE_C
			Stringed.play()MIDDLE_C
			Brass.play() MIDDLE_C
			WoodWind.play() MIDDLE_C
		 */
	}
}
