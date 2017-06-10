package polymorphism.shape;

import java.util.Random;

public class RandomShapeGenerator {
	private Random random = new Random(47);
	Shape shape;
	public Shape next() {			//有无break将会产生不一样的结局,不信你试试
		switch (random.nextInt(3)) {
		case 0: shape = new Circle();
				break;
		case 1: shape = new Square();
				break;
		case 2: shape = new Triangle();
				break;
		default:
		}
		return shape;
	}
	
	public static void main(String[] args) {
		RandomShapeGenerator gen = new RandomShapeGenerator();
		while(true){
			System.out.println(gen.random.nextInt(3));
		}
	}
}
