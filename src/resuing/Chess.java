package resuing;

/**
 * 初始化基类(带参数的构造器)
 * 	  1. 如果基类带有默认的构造器,编译器可以轻松地调用它,  是因为不必考虑要传递什么样的
 * 参数问题,  但是, 如果没有默认的基类构造器,或者想调用一个带参数的基类构造器,就必须
 * 用关键字super显式地编写调用基类构造器的语句,并且配以适当的参数.
 * 	  2. 如果不在BoardGame()中调用基类的构造器,编译器将"抱怨"无法找到符合Game()形式的构造器.
 * 	调用基类构造器必须是你在导出类构造器中要做的第一件事儿.
 * @author admin
 *
 */
class Game {
	public Game(int i) {
		System.out.println("Game Constructor");
	}
}

class BoardGame extends Game {
	public BoardGame(int i) {
		super(i);		//调用基类的构造方法
		System.out.println("BoardGame Constuctor");
	}
}

public class Chess extends BoardGame{
	public Chess() {
		super(11);
		System.out.println("Chess Constructor");
	}
	
	public static void main(String[] args) {
		Chess x = new Chess();
		
		/**
		 * Game Constructor
			BoardGame Constuctor
			Chess Constructor

		 */
	}
}
