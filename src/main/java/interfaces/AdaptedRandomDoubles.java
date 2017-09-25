package interfaces;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

/**
 * 适配接口----适配器设计模式
 * 		1.假设你又一个还未实现Readable的类RandomDoubles,它可以产生随机浮点数.
 * 此时,再次使用了适配器模式,但是在本例子中,被适配的类可以通过继承和实现Readable接口来创建.
 * 因此,通过使用interface关键字提供的伪多重继承机制,我们可以生成既是RandomDoubles又是
 * Readable的新类.
 * 		2.接口的强大之处:  因为在这种方式中,我们可以在任何现有类之上添加新的接口,所有这意味着
 * 让方法接受接口类型,是一中让任何类都可以对该方法进行适配的方式(Scanner()构造方法),这就是使用
 * 接口而不是类的强大之处.
 * @author admin
 *
 */
public class AdaptedRandomDoubles extends RandomDoubles
							implements Readable{
	private int count;
	public AdaptedRandomDoubles(int count) {
		this.count = count;
	}
	
	@Override
	public int read(CharBuffer cb) throws IOException {
		if (count-- == 0) 
			return -1;
		String result = Double.toString(next()) + " ";
		cb.append(result);
		return result.length();
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(new AdaptedRandomDoubles(7));
		while (s.hasNext()) {
			String string = (String) s.next();
			System.out.println(string);
			
			
			/**
			 * 0.7271157860730044
				0.5309454508634242
				0.16020656493302599
				0.18847866977771732
				0.5166020801268457
				0.2678662084200585
				0.2613610344283964
			 */
		}
	}
}	
