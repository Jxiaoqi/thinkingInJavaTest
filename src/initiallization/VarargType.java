package initiallization;

/**
 * 	在可变参数列表里,可以使用任何类型的参数,包括基本类型
 * 	int 类型数组的class 为: class [I
 * @author admin
 *
 */
public class VarargType {

	static void f(Character... args){
		System.out.print(args.getClass());
		System.out.println(" length " + args.length);
	}
	
	static void g(int... args){
		System.out.print(args.getClass());
		System.out.println(" length " + args.length);
	}
	
	public static void main(String[] args) {
		f('a');
		f();
		g(1);
		g();
		System.out.println(new int[0].getClass());
		
		/**
		 * class [Ljava.lang.Character; length 1
			class [Ljava.lang.Character; length 0
			class [I length 1
			class [I length 0
			class [I

		 */
	}
}
