package resuing;

import java.util.Random;

/**
 *  final数据
 *  1. 有时数据的恒定不变是很有用的,比如: 1. 一个永不改变的编译时常亮.   2.一个在运行时被初始化的值,而你不希望改变它.
 *  2. 在JAVA 中, 编译期常亮必须是基本类型的,并且以关键字final表示,在对这个常量进行定义的时候,必须对其赋值.(
 *  	可以在编译时执行计算式,减轻了一些运行负担)
 *  3.一个既是static又是final 的域只占据一段不能改变的存储空间.	fd1,fd2的比较
 *  4. final 修饰对象引用而不是基本数据类型时:  对于基本数据类型,final使数值恒定不变; 而对于对象引用,final使得引用
 *  恒定不变( 一旦引用被初始化指向一个对象,就无法再把它改为指向另一个对象.然而,对象其自身是可以修改的(对象中的域))
 *  
 * @author admin
 *
 */
class Value {
	int i;    //package Access
	public Value(int i) { this.i = i; }
}

public class FinalData {
	private static Random rand = new Random(47);
	private String id;
	public FinalData(String id) { this.id = id;	}
	
	// can be ocmpile-time constants
	private final int valueOne = 9;
	private static final int VALUE_TWO = 99;
	
	//Cannot be compile-time constants
	private final int i4 = rand.nextInt(20);
	static final int INT_5 = rand.nextInt(20);
	private Value v1 = new Value(11);
	private final Value v2 = new Value(22);
	private static final Value VAL_3 = new Value(33);
	
	private final int[] a = {1, 2, 3, 4, 5, 6};
	@Override
	public String toString() {
		return id + ": " + "i4 = " + i4 + ", INT_5 = " + INT_5;
	}
	
	public static void main(String[] args) {
		FinalData fd1 = new FinalData("fd1");
		//fd1.valueOne++;    The final field FinalData.valueOne cannot be assigned
		fd1.v2.i++;			//Object isn't constant
		fd1.v1 = new Value(9);	//ok ,not final
		for (int i = 0; i < fd1.a.length; i++) {
			fd1.a[i]++;			//Object isn't constant!
		}
		//fd1.v2 = new Value(0);		//The final field FinalData.v2 cannot be assigned 
		//fd1.VAL_3 = new Value(1);		//The final field FinalData.VAL_3 cannot be assigned
		//fd1.a = new int[3];				//The final field FinalData.a cannot be assigned
		System.out.println(fd1);
		System.out.println("Creating new FinalData");
		FinalData fd2 = new FinalData("fd2");
		System.out.println(fd1);
		System.out.println(fd2);
		
		
		/**
		 * fd1: i4 = 15, INT_5 = 18
			Creating new FinalData
			fd1: i4 = 15, INT_5 = 18
			fd2: i4 = 13, INT_5 = 18
		 */
	}
	
	
}
