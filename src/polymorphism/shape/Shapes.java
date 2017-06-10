package polymorphism.shape;

/**
 * 产生正确的行为
 *  	在编译时,编译器不需要获取任何特殊信息就能进行正确的调用.对draw()方法的
 *  所有调用都是通过动态绑定进行的.
 * @author admin
 *
 */
public class Shapes {
	private static RandomShapeGenerator gen = 
			new RandomShapeGenerator();
	public static void main(String[] args) {
		Shape [] s = new Shape[9];
		//fill up the array with shapes;
		for (int i = 0; i < s.length; i++) {
			s[i] = gen.next();
			System.out.println(s[i]);
		}
		System.out.println(s.length);
		//make polymophic calls;
		for (Shape shape : s) {
			shape.draw();
		}
	}
}
