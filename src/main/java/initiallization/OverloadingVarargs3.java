package initiallization;

/**
 *  如果给两个方法都添加一个非可变参数,就可以解决,  非可变参数的重载问题.
 * @author admin
 *
 */
public class OverloadingVarargs3 {
	
	static void f(float i, Character... args){
		System.out.println("first");
	}
	
	static void f(char c, Character... args){
		System.out.println("second");
	}
	
	public static void main(String[] args) {
		f(1, 'a');
		f('a', 'b');
	}

}
