package operators;

import static util.Print.*;

/**
 * 几个特殊值，比如：正值的最大表示为0111 1111，即127。负值的最小表示为1000 0000，即-128。
 * 此demo演示了  移位操作符  ,已经操作比int类型小得整型时,会将二进制转换成int类型以后再进行操作
 * @author admin
 *
 */
public class URShift {
	
	public static void main(String[] args) {
		int i = -1;
		print(Integer.toBinaryString(i));   //32位  11111111111111111111111111111111
		i >>>= 10;
		print(Integer.toBinaryString(i));  //22为  1111111111111111111111
		
		long l = -1;
		print(Long.toBinaryString(l));	   //64位  1111111111111111111111111111111111111111111111111111111111111111
		l >>>= 10;
		print(Long.toBinaryString(l));     //64为 111111111111111111111111111111111111111111111111111111
		
		short s = -1;
		print(Integer.toBinaryString(s));	//32位  11111111111111111111111111111111
		s >>>= 10;
		print(Integer.toBinaryString(s));	//32位  11111111111111111111111111111111
		
		byte b = -1;
		print(Integer.toBinaryString(b));   //32位 11111111111111111111111111111111
		b >>>= 10;
		print(Integer.toBinaryString(b));	//32位 11111111111111111111111111111111

		b = -1;
		print(Integer.toBinaryString(b));	// 32位 11111111111111111111111111111111
		print(Integer.toBinaryString(b >>> 10));	//22位 1111111111111111111111
	}
	

}
