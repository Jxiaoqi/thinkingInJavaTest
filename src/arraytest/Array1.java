package arraytest;

public class Array1 {
	
	//定义数组的三种方式:
	
	//1.　方式1（推荐，更能表明数组类型）      type[] 变量名 = new type[数组中元素的个数];
	int[] a = new int[10];
	
	//2.  方式2（同C语言）   type变量名[] = new type[数组中元素的个数];
	int b[] = new int[10];
	
	//方式3   定义时直接初始化    type[] 变量名 = new type[]{逗号分隔的初始化值};
	int c[] = {1,2,3};
	int d[] = new int[]{1,2,3};		//其中int[] a = new int[]{1,2,3,4};的第二个方括号中不能加上数组长度，因为元素个数是由后面花括号的内容决定的。
	
	
	//数组内容的比较可以用equals()方法吗?
	int a1[] = {1,2,3};
	int b1[] = {1,2,3};
	//System.out.println(a1.equals(b1));    //输出false
	/*
	 * 怎么比较呢？一种解决方案是自己写代码，另一种方法是利用java.util.Arrays。java.util.Arrays中的方法全是static的。其中包括了equals()方法的各种重载版本。
	 */
	
	public static void main(String[] args) {
		
		
		
	}
	
	
}
