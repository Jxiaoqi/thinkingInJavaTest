package resuing;

/**
 * 空白 final  
 * 		1.java 允许生成 " 空白final", 所谓空白 final 是指被声明为final 
 * 	但又为给定初值的域.
 * 		2.无论什么情况,编译器都确保空白 final在使用在被初始化. 必须在域的定义处或者每个构造器中用表达式对final进行赋值
 * 		3.空白final在关键是  final 的使用上提供了更大的灵活性: 一个类中的 final域就可以做到
 * 根据对象有所不同,却又保持其恒定不变的特性.
 * 
 * 
 * @author admin
 *
 */
class Poppet {
	private int i;
	public Poppet(int i) { this.i = i; }
}

public class BlankFinal {
	private final int i = 0;      //Initialized final
	private final int j; 		  // Blank final
	private final Poppet p;       //Blank final reference
	
	public BlankFinal() {
		j = 1;
		p = new Poppet(1);
	}
	
	public BlankFinal(int x) {
		j = x;        			//Initialized bland field
		p = new Poppet(x);		//Initialized blank final reference
	}
	
	public static void main(String[] args) {
		new BlankFinal();
		new BlankFinal(47);
	}
	
	
}
