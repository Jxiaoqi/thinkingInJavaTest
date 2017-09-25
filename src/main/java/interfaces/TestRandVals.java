package interfaces;

import static util.Print.*;

/**
 * 初始化接口中的域:
 * 		1.既然域是static的,它们就可以在第一次被加载时初始化,这发生在任何域首次被访问时.
 * 		2.这些域不是接口的一部分,它们的值被存储在该接口的静态存储区域内.
 * @author admin
 *
 */
public class TestRandVals {
	public static void main(String[] args) {
		print(RandVals.RANDOM_INT);
		print(RandVals.RANDOM_LONG);
		print(RandVals.RANDOM_FLOAT);
		print(RandVals.RAND_DOUBEL);
		
		/**
		 * 8
			-32032247016559954
		0.534122
		1.6020656493302599

		 */
	}
}
