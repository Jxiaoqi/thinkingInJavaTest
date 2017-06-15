package interfaces;

import static util.Print.*;

/**
 * 接口与工厂   ---工厂设计模式
 * 		1.为什么我们想要添加这种额外级别的间接性呢? 一个常见的原因就是要创建框架:  假设你
 * 正在创建一个对弈游戏系统.如下:
 * 		2.如果Games类表示一段复杂的代码,那么这种方式就允许你在不同类型的游戏中复用这段代码.
 * 
 * @author admin
 *
 */
interface Game {
	boolean move();
}

interface GameFactory {
	Game getGame();
}

class Checkers implements Game {
	private int moves = 0;
	private static final int MOVES = 3;
	
	@Override
	public boolean move() {
		print("Checkers move " + moves);
		return ++moves != MOVES;
	}
	
}

class CheckersFactory implements GameFactory {

	@Override
	public Game getGame() {
		return new Checkers();
	}
	
}

class Chess implements Game {
	private int moves = 0;
	private static final int MOVES = 5;
	
	@Override
	public boolean move() {
		print("Chess move " + moves);
		return ++moves != MOVES;
	}
}

class ChessFactory implements GameFactory {
	@Override
	public Game getGame() {
		return new Chess();
	}
	
}

public class Games {
	public static void playGame(GameFactory fact) {
		Game g = fact.getGame();
		while (g.move()) 
			;
			
	}
	
	public static void main(String[] args) {
		playGame(new CheckersFactory());
		playGame(new ChessFactory());
		
		/**
		 * Checkers move 0
			Checkers move 1
			Checkers move 2
			Chess move 0
			Chess move 1
			Chess move 2	
			Chess move 3
			Chess move 4
		 */
	}
}
