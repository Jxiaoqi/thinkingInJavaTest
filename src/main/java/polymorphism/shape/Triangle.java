package polymorphism.shape;

public class Triangle extends Shape{
	@Override
	public void draw() {
		System.out.println("Trianlge.draw()");
	}
	
	@Override
	public void earse() {
		System.out.println("Triangle.earse()");
	}
}
