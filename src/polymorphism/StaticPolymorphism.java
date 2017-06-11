package polymorphism;
// Static methods are not polymorphic
class StaticSuper {
	public static String staticGet() {
		return "Basic staticGet()";
	}
	
	public String dynamicGet() {
		return "Base dynamicGet()";
	}
}

class StaticSub extends StaticSuper {
	public static String staticGet() {
		return "Derived staticGet()";
	}
	
	@Override
	public String dynamicGet() {
		return "Derived dynamicGet()";
	}
}

/**
 * 多态的缺陷：静态方法不具有多态性
 * 		如果某个方法是静态的，它的行为就不具有多态性。
 * 		静态方法是与类，而并非与单个对象相关联的。
 * @author 贾玉豪
 *
 */
public class StaticPolymorphism extends StaticSuper {
	public static void main(String[] args) {
		StaticSuper sup = new StaticSub();
		System.out.println(sup.staticGet());     //The static method staticGet() from the type StaticSuper should be accessed in a static way
		System.out.println(sup.dynamicGet());
		/**
		 * Basic staticGet()
			Derived dynamicGet()
		 */
		}

}
