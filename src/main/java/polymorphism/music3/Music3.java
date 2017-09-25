package polymorphism.music3;

import polymorphism.music.Note;
import static util.Print.*;

/**
 * 可扩展性
 * 		当我们将某种引用置于orchestra数组中,就会自动向上转型到Instrument
 * @author admin
 *
 */
class Instrument {
	void play(Note n) { print("Instrument.play() " + n);}
	String what() { return "Instrument";}
	void adjust() { print("Adjusting Instrument");}
}

class Wind extends Instrument {
	@Override
	void play(Note n) {
		print("Wind.play() " + n);
	}
	@Override
	String what() {
		return "Wind";
	}
}

class Percussion extends Instrument {
	@Override
	void play(Note n) {
		print("Percussion.play() " + n);
	}
	
	@Override
	String what() {
		return "Percussion";
	}
}

class Stringed extends Instrument {
	@Override
	void play(Note n) {
		print("Stringed.play() " + n);
	}
	@Override
	String what() {
		return "Stringed";
	}
}

class Brass extends Instrument {
	@Override
	void play(Note n) {
		print("Brass.play() " + n);
	}
	@Override
	String what() {
		return "Brass";
	}
}

class Woodwind extends Wind {
	@Override
	void play(Note n) {
		print("Woodwind.play() " + n);
	}
	@Override
	String what() {
		return "Woodwind";
	}
}


public class Music3 {
	public static void tune(Instrument i) {
		i.play(Note.MIDDLE_C);
	}
	
	public static void tuneAll(Instrument[] e) {
		for (Instrument instrument : e) {
			tune(instrument);
		}
	}
	
	public static void main(String[] args) {
		Instrument[] orchestra = {
				new Wind(),
				new Percussion(),
				new Stringed(),
				new Brass(),
				new Woodwind()
		};
		tuneAll(orchestra);
		
		/**
		 * Wind.play() MIDDLE_C
			Percussion.play() MIDDLE_C
			Stringed.play() MIDDLE_C
			Brass.play() MIDDLE_C
			Woodwind.play() MIDDLE_C
		 */
	}
}
