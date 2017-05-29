package operators;
import static util.Print.*;

/**
 * 在许多编程语言中,方法f()似乎是要在它的作用域内复制其参数Letter y的一个副本,
 * 但实际上只是传递了一个引用
 * @author admin
 *
 */
public class PassObject {
	
	static void f(Letter letter){
		letter.c = 'z';
	}
	
	public static void main(String[] args) {
		Letter x = new Letter();
		x.c = 'a';
		print("1: x.c= :" + x.c);
		f(x);
		print("2: x.c= :" + x.c);
		
		/**
		 * 1: x.c= :a
			2: x.c= :z
		 */
	}

}

class Letter{
	char c;
}