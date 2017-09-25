package initiallization;

/**
 * JDK 5.0以后对  可变参数列表的支持
 * 
 * 
 * @author admin
 *
 */
public class NewVarArgs {
	
	static void printArray(Object... args){
		for (Object object : args) 
			System.out.print(object + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		printArray(new Integer(47), new Float(3.14), new Double(11.11));
		printArray(47, 3.14F, 11.11);
		printArray("one","tow","three");
		printArray(new A(), new A(),new A());
		
		//or a array:
		printArray((Object[])new Integer[]{1, 2, 3, 4, 5});
		printArray();	//Empty list is ok   表明将0个参数传递给可变参数列表是可行的.当具有可选的尾随参数时,这一特性就会很有用,见 OptionalTrailingArgument.java
	}
	
	

}
