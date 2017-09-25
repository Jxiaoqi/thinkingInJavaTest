package initiallization;

/**
 * 可变参数列表是的重载过程变得复杂了.
 * 	在每一种情况下,编译器都会使用自动包装机制来匹配重载方法,然后调用最明确匹配的方法.
 * 	但是在不是用参数调用f()时,编辑器就无法知道应该调用哪一个方法了.
 * @author admin
 *
 */
public class OverloadingVarargs {
	static void f(Character... args){
		System.out.print("first");
		for (Character c : args) {
			System.out.print(" " + c);
		}
		System.out.println();
	}
	static void f(Integer... args){
		System.out.print("second");
		for (Integer i : args) {
			System.out.print(" " + i);
		}
		System.out.println();
	}
	static void f(Long... args){
		System.out.println("third");
	}
	public static void main(String[] args) {
		f('a', 'b', 'c', 'd');
		f(1);
		f(2,1);
		f(0);
		f(0L);
		//!  f(); Won't compile
	}
	

}
