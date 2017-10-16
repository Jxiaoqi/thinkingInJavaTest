package arithmetic;

import java.util.Scanner;

/**
 * 利用递归的方式计算 N 的阶乘
 * @author admin
 *
 */
public class Factor {
	
	public static void main(String[] args) {
		int number;
		int factorial;
		while (true) {
			System.out.println("please enter a number..........");
			Scanner scanner = new Scanner(System.in);
			number = scanner.nextInt();
			factorial = factor(number);
			System.out.println(number + "的阶乘为:" + factorial);
			
		}
		
	}
	
	public static int factor(int n){
		if (n<=1) {
			return 1;
		}else{
			return n * factor(n-1);
		}
	}

}
