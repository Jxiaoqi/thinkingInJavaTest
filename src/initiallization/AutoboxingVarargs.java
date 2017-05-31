package initiallization;

/**
 * 可变参数列表可以和    自动包装机制  和谐相处
 * @author admin
 *
 */
public class AutoboxingVarargs {
	public static void f(Integer... args){
		for (Integer i : args) 
			System.out.print(i + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		f(new Integer(1), new Integer(2));
		f(4, 5, 6, 7, 8);
		f(10, new Integer(11), 12);
		
		/**
		 * 1 2 
			4 5 6 7 8 
			10 11 12 
		 */
	}
}
