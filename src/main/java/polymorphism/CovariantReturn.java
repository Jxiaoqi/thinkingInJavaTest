package polymorphism;


/**
 * 多态:  协变返回类型
 * 		1. JavaSE5中添加了协变返回类型,它表示导出类中的覆盖方法可以返回基类方法的
 * 返回类型的某种导出类型.
 * 		2. JavaSE5与java较早版本之间的主要差异就是较早的版本将强制执行process()的
 * 覆盖版本必须返回Grain,而不能返回Wheat,尽管Wheat是从Grain导出的,因而应该是一中合法
 * 的返回类型.协变类型允许返回更具体的Wheat类型.
 * @author admin
 *
 */
class Grain {		// 谷物
	@Override
	public String toString() {
		return "Grain";
	}
}

class Wheat extends Grain { //小麦
	@Override
	public String toString() {
		return "Wheat";
	}
}

class  Mill {						//磨粉
	Grain process() { return new Grain();}
}

class WheatMill extends Mill {		//面粉；小麦粗粉
	@Override
	Wheat process() {
		// TODO Auto-generated method stub
		return new Wheat();
	}
}
public class CovariantReturn {
	public static void main(String[] args) {
		Mill m = new Mill();
		Grain g = m.process();
		System.out.println(g);
		
		m = new WheatMill();	//upcasting
		g = m.process();
		System.out.println(g);
		
		/**
		 * Grain
			Wheat
		 */
	}
}
