package polymorphism.music;

/**
 * 向上造型
 *    这种把对某个对象的引用视作对其基类类型的引用的做法叫做向上造型.
 * @author admin
 *
 */
public class Music {
	public static void tune(Instrument i) {
		i.play(Note.MIDDLE_C);
	}
	
	public static void main(String[] args) {
		Wind wind = new Wind();
		tune(wind);
		
		/**
		 * Wind.playMIDDLE_C
		 */
	}
}
