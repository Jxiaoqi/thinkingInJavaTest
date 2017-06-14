package interfaces;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;


/**
 * 适配接口  -----策略设计模式;
 * 		1.接口最吸引人的原因之一就是允许用一个接口具有不同的具体实现.在简单的情况下,它的体现形式通常
 * 是一个接受接口类型的方法, 而该接口的实现 和 向该接口方法传递的对象则取决于方法的使用者.  因此.
 * 		2.策略设计模式:  接口的一种常见方法就是前面提到的----策略设计模式,此时,你编写一个执行
 * 某些操作的方法,而该方法将接受一个同样是你指定的接口.  你主要就是要生命:" 你可以用任何你想要的对象来
 * 调用我的方法,只要你的对象遵循我的接口", 这使得你的方法更加灵活,通用,并更具有可复用性.
 * 		3.
 * @author admin
 *
 */
public class RandomWords implements Readable {

	private static Random rand = new Random(47);
	private static final char[] capitals = 
			"ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private static final char[] lowers = 
			"abcdefghijklmnopqrstuvwxyz".toCharArray();
	private static final char[] vowels = 
			"aeiou".toCharArray();
	private int count;
	public RandomWords(int count) {
		this.count = count;
	}
	
	@Override
	public int read(CharBuffer cb) throws IOException {
		if (count-- == 0) {
			return -1;   				//读到了缓冲区末尾  Indicats end of input
		}
		cb.append(capitals[rand.nextInt(capitals.length)]);   //追加一个大写字母
		for (int i = 0; i < 4; i++) {
			cb.append(vowels[rand.nextInt(vowels.length)]);
			cb.append(lowers[rand.nextInt(lowers.length)]);		//追加一个元音字母  和一个 小写字母,  4次
		}
		cb.append(" ");					//追加一个换行符
		return 10;						//Number of characters appended
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(new RandomWords(10));
		while (s.hasNext()) {
			 System.out.println(s.next());
		}
		
		/**
		 * Yazeruyac
			Fowenucor
			Goeazimom
			Raeuuacio
			Nuoadesiw
			Hageaikux
			Ruqicibui
			Numasetih
			Kuuuuozog
			Waqizeyoy
		 */
	}

}
