package control;

import java.util.Random;

import static util.Print.*;

/**
 * @author admin
 *
 */
public class ViwelAndConstants {

	public static void main(String[] args) {
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			int c = rand.nextInt(26) + 'a';
			printnb((char)c + " ," + c + ": ");
			switch (c) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u': print("vowel");
					break;
			case 'y':
			case 'w': print("sometimes a vowel");
					break;
			default: print("constant");
				break;
			}
		}
		
	}
}
