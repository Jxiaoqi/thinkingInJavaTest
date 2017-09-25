package holding;

import util.Stack;
/**
 * P413
 * 栈 
 * @author admin
 *
 */
public class StackTest {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		for (String s : "My dog has fleas".split(" ")) 
			stack.push(s);
		
		while (!stack.empty()) 
			System.out.print(stack.pop() + " ");
		
		/**
		 * fleas has dog My 
		 */
	}
}
