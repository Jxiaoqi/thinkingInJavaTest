package arraytest;

/**
 * 二维数组是数组的数组。
 * 基本的定义方式有两种形式，如：
 * 		type[][] i = new type[2][3];（推荐）　　
 * 		type i[][] = new type[2][3];
 * @author admin
 *
 */
public class Array3 {
	
	public static void main(String[] args) {
		
		int i[][] = new int[2][3];
		
		System.out.println("is i an object? " + 
								(i instanceof Object));
		System.out.println("is i[0] an object? " + 
								(i[0] instanceof Object));
		
	}

}
