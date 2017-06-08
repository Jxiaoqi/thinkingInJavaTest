package resuing;

import static util.Print.*;

/**
 * 名称屏蔽
 * 		如果基类拥有某个已被多次重载的方法名称,在导出类中重新定义该方法名称
 * 并不会屏蔽其在基类中的任何版本.
 * @author admin
 *
 */
class Homer {
	char doh(char c) {
		print("doh(char)");
		return  'd';
	}
	float doh(float f) {
		print("doh(float)");
		return 1.0f;
	}
}

class MilHouse {}

class Bart extends Homer {
	void doh(MilHouse house) {
		print("doh(Milhouse)");
	}
}
public class Hide {
	public static void main(String[] args) {
		Bart b = new Bart();
		b.doh(1);
		b.doh('x');
		b.doh(1.0f);
		b.doh(new MilHouse());
		
		/**
		 * doh(float)
doh(char)
doh(float)
doh(Milhouse)

		 */
	}
}
