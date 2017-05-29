package initiallization;

/**
 * 该程序展示了 将0个参数传递给可变参数列表是可行的,当具有可选的尾随参数时,这一特性就很有用.
 * @author admin
 *
 */
public class OptionalTrailingArgument {
	
	static void f(int required, String... trailing){
		System.out.print("required: " + required + " ");
		for (String string : trailing) 
			System.out.print(string + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		f(1, "one");
		f(2, "thw","three");
		f(0);
		
		/**
		 * required: 1 one 
			required: 2 thw three 
			required: 0 
		 */
	}

}
