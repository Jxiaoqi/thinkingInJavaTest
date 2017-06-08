package resuing;

/**
 * 向上转型.
 *  1.由于继承可以确保基类中所有的方法在导出类中同样有效,所以能够向基类发送的所有的信息同样也可以向导出类发送.
 *  2. 我们可以准确地说,Wind类也是一种类型的Instrument
 *  3. 在tune()中,程序代码可以对Instrument 和 它所有的导出类起作用, 这种将Wind引用转换为InStrument
 *  引用的动作,称之为   向上转型.
 * @author admin
 *
 */
class Instrument {
	public void play() {}
	static void tune(Instrument i) {
		//...
		i.play();
	}
}

public class Wind extends Instrument {
	public static void main(String[] args) {
		Wind flute = new Wind();
		Instrument.tune(flute);
	}
}
