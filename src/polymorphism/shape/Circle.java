package polymorphism.shape;

public class Circle extends Shape {
	@Override
	public void draw() {
		System.out.println("Cricle.draw()");
	}
	
	@Override
	public void earse() {
		System.out.println("Circle.earse()");
	}
}
