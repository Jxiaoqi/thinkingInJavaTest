package initiallization;

class A	{}

/**
 * 可变参数列表      创建以数组为参数的方法
 * @author admin
 *
 */
public class VarArgs {
	static void printArray(Object[] args){
		for (Object object : args) 
			System.out.print(object + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		printArray(new Object[]{
				new Integer(47), new Float(3.14), new Double(11.11)
		});
		printArray(new Object[]{"one","two","three"});
		printArray(new Object[]{new A(), new A(), new A()});
		
		/**
		 * 47 3.14 11.11 
			one two three 
			initiallization.A@50a5314 initiallization.A@68d448a1 initiallization.A@48ec77cb 

		 */
	}
}
