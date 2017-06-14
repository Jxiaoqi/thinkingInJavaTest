package interfaces.music4;

import polymorphism.music.Note;
import static util.Print.*;

/**
 * 抽象类和抽象方法 
 * 		1.抽象类: 通用接口建立起一种基本形式,以此表示所有导出类的共同部分.包含抽象方法的类叫做    抽象类,
 * 如果一个类包含一个多多个抽象方法,改类必须被限定为抽象类.
 * 		2. 抽象方法: 这种方法不是完整的; 仅有方法声明而没有方法体.
 * 		3.一个类从抽象类继承, 那么就必须为基类中的所有抽象方法提供方法定义. 如果不这样做(可以选择不走),
 * 那么导出类便也是抽象类,且编译器会强制我们用abstract关键字来限定这个类.
 * 		4.创建抽象类和抽象方法非常有用,因为他们可以使类的抽象明确起来,并告诉用户和编译器怎样来使用他们.
 * 抽象类还是很有用的重构工具,因为他们使得我们可以很容易地将公共方法沿着继承层次结构向上移动.
 * @author admin
 *
 */
abstract class Instrument {
	private int i;
	public abstract void play(Note n);
	public String what(){
		return "Instrument";
	}
	public abstract void adjust();
}

class Wind extends Instrument {

	@Override
	public void play(Note n) {
		print("Wind.play() " + n); 
	}

	@Override
	public String what() {
		return "What";
	}
		
	@Override
	public void adjust() { }
	
}

class Percussion extends Instrument {

	@Override
	public void play(Note n) {
		print("Percussion.play() " + n);
	}

	@Override
	public String what() {
		return "Percussion";
	}
	
	@Override
	public void adjust() {}
	
}

class Stringed extends Instrument {

	@Override
	public void play(Note n) {
		print("Stringed.play() " + n);
	}
	
	@Override
	public String what() {
		return "Stringed";
	}
	
	@Override
	public void adjust() {
		// TODO Auto-generated method stub
	}
	
}

class Brass extends Wind {
	@Override
	public void play(Note n) {
		print("Brass.play() " + n );
	}
	@Override
	public void adjust() {
		print("Brass.adjust()");
	}
}

class WoodWind extends Wind {
	@Override
	public void play(Note n) {
		print("WoodWind.play() " + n);
	}
	@Override
	public void adjust() {
		print("WoodWing.adjust()");
	}
}

public class Music4 {
	static void tune(Instrument i) {
		i.play(Note.MIDDLE_C);
	}
	
	static void tuneAll(Instrument[] e) {
		for (Instrument i : e) {
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
			Percussion.play() MIDDLE_C
			Stringed.play() MIDDLE_C
			Brass.play() MIDDLE_C
			WoodWind.play() MIDDLE_C
		 */
	}
}
