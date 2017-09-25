package polymorphism.music;

import static util.Print.*;

/**
 * 忘记对象类型
 * 		1. why 这个 样的缺点: 必须为添加的每一个Instrument类编写特定类型的
 * 方法(tune),这意味着开始时需要更多的编程,也意味着如果以后想添加类似tune()的新方法,
 * 或者添加自Instrument 导出的新类,仍需要做大量的工作
 *     2. how  多态的处理方法: 如果我们只要一个简单的方法,它仅接受基类作为参数,而不是
 * 那些特殊的导出类
 * 
 * @author admin
 *
 */
//弦乐
class Stringed extends Instrument {
	public void play(Note n) {
		print("Stringed.play()" + n);
	};
}
//管乐
class Brass extends Instrument {
	@Override
	public void play(Note n) {
		print("Brass.play" + n);
	}
}

public class Music2 {
	public static void tune(Wind i) {
		i.play(Note.MIDDLE_C);
	}
	public static void tune(Stringed s) {
		s.play(Note.MIDDLE_C);
	}
	public static void tune(Brass b) {
		b.play(Note.MIDDLE_C);
	}
	public static void main(String[] args) {
		Wind flute = new Wind();
		Stringed voilin = new Stringed();
		Brass frenchHron = new Brass();
		tune(flute);
		tune(voilin);
		tune(frenchHron);
	}
}
