package interfaces;

import java.util.Random;

/**
 * 初始化接口中域:
 * 		在接口总定义的域不能是"空final",但是可以被非常量式初始化.
 * @author admin
 *
 */
public interface RandVals {
	Random RAND = new Random(47);
	int RANDOM_INT = RAND.nextInt(10);
	long RANDOM_LONG = RAND.nextLong() * 10;
	float RANDOM_FLOAT = RAND.nextFloat() * 10;
	double RAND_DOUBEL = RAND.nextDouble() * 10;
}
