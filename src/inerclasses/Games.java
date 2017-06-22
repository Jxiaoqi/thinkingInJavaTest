package inerclasses;


/**
 * 使用匿名内部类来改进Games
 * @author admin
 *
 */
interface Game { boolean move();}
interface GameFactory { Game getGame();}

class Checkers implements Game {
	
	private int move = 0;
	private static final int MOVES = 3;
	
	private Checkers() {}
	
	@Override
	public boolean move() {
		System.out.println("Checkers move " + move );
		return move++ != MOVES;
	}
	
	public static GameFactory factory = new GameFactory() {
		
		@Override
		public Game getGame() {
			return new Checkers();
		}
	}; 
	
}

class Chess implements Game {
	private int move = 0;
	private static final int MOVES = 5;
	private Chess() {}
	
	@Override
	public boolean move() {
		System.out.println("Chess move " + move);
		return move++ != MOVES;
	}
	
	public static GameFactory factory = new GameFactory() {
		
		@Override
		public Game getGame() {
			return new Chess();
		}
	};
	
}

public class Games {
	public static void playGame(GameFactory fact) {
		Game g = fact.getGame();
		while (g.move())
			;
	}
	
	public static void main(String[] args) {
		playGame(Checkers.factory);
		playGame(Chess.factory);
		
		/**
		 * Checkers move 0
			Checkers move 1
			Checkers move 2
			Checkers move 3
			Chess move 0
			Chess move 1
			Chess move 2
			Chess move 3
			Chess move 4
			Chess move 5

		 */
	}
}
