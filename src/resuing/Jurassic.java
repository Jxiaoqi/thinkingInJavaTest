package resuing;

/**
 * final 类
 * 	1.当将某个类的整体定义为final时,就表明了你不打算集成该类,而且也不允许别人这样做.
 * 	2.final类的域可以根据个人意愿选择为是或不是 final.不论类是否被定义为final,相同的规则都适用于
 * 定义为 final的域.
 *  3.由于 final类禁止继承,所以final 类中所有的方法都隐式指定为是final的,因为无法覆盖他们.
 * 
 * @author admin
 *
 */

class SmallBrain {}

final class Dinosaur {
	int i = 7;
	int j = 1;
	SmallBrain x = new SmallBrain();
	void f() {}
}

//!class Further extends Dinosaur {}
//error: Cannot extend final class 'Dinosaur'

public class Jurassic {
	public static void main(String[] args) {
		Dinosaur d = new Dinosaur();
		d.f();
		d.j = 40;
		d.i++;
	}
}
