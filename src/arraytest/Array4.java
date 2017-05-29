package arraytest;

/**
 * 变长的二维数组
 * 二维数组的每个元素都是一个一维数组，这些数组不一定都是等长的。
 *　声明二维数组的时候可以只指定第一维大小，空缺出第二维大小，之后再指定不同长度的数组。但是注意，第一维大小不能空缺（不能只指定列数不指定行数）。
 * @author admin
 *
 */
public class Array4 {
	
	public static void main(String[] args) {
		
		int a[][] = new int[3][];
		a[0] = new int[2];
		a[1] = new int[3];
		a[2] = new int[4];
		
		//Error: 不能空缺第一维大小
		//int b[][] = new int[][4];
		
	}

}
