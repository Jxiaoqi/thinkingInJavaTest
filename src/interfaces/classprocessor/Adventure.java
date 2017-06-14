package interfaces.classprocessor;


/**
 * jva中的多重继承:
 * 		1.在导出类中,不强制要求必须有个是抽象的或  "具体的"(没有任何抽象方法的)基类.
 * 如果要从一个非接口的类继承,那么只能从一个类去继承.其余的元素都必须是接口.
 * 		2. 当通过如下方式将一个具体的类和 多个接口组合在一起时,这个具体类必须放在前面,
 * 后面跟着的才是接口(否则编译器会报错)
 * 		3. 该例展示了使用接口的核心原因:  
 * 				1.为了能够向上转型为多个基本类型(以及由此而带来的灵活性)
 * 				2. 与使用抽象类相同  : 防止客户端程序员创建该类的对象,并确保这仅仅是
 * 	建立一个接口.
 * 		4. 我们应该使用接口还是抽象类  ?  
 * 			如果要创建不带任何定义和成员变量的基类,那么就应该选择接口而不是抽象类.  事实上
 * 	,如果知道某事物应该成为一个基类,那么第一选择应该是使它成为一个接口.
 * @author admin
 *
 */
interface CanFight {
	void fight();
}

interface CanSwim {
	void swim();
}

interface CanFly {
	void fly();
}

class ActionCharacter {
	public void fight(){}
}

class Hero extends ActionCharacter 
			implements CanFight, CanSwim, CanFly {

	@Override
	public void fly() {	}

	@Override
	public void swim() {}
	
}

public class Adventure {
	public static void t(CanFight x) { x.fight();}
	public static void u(CanSwim x) { x.swim();}
	public static void v(CanFly x) { x.fly();}
	public static void w(ActionCharacter x) { x.fight();}
	
	public static void main(String[] args) {
		Hero h = new Hero();
		t(h);
		v(h);
		u(h);
		w(h);
	}
}
