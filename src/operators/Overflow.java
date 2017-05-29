package operators;
/**
 * 演示了int 类型乘法的溢出问题
 * @author admin
 *
 */
public class Overflow {
	public static void main(String[] args) {
		int big = Integer.MAX_VALUE;
		System.out.println("max = " + big);
		int bigger = big * 4;
		System.out.println("bigger = " + bigger);
		
		//max = 2147483647
		//bigger = -4
	}
}
