package polymorphism.shape;

public class Square extends Shape {
	@Override
	public void draw() {
		System.out.println("Squqre.draw()");
	}
	
	@Override
	public void earse() {
		System.out.println("Square.earse()");
	}
}
