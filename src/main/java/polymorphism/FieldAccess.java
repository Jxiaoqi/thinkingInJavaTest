package polymorphism;

class Super {
	public int field = 0;

	public int getField() {
		return field;
	}
}

class Sub extends Super {
	public int field = 1;
	
	@Override
	public int getField() {
		// TODO Auto-generated method stub
		return field;
	}
	
	public int getSuperField() {
		return super.field;
	}
}

/**
 * 多态的缺陷: 域访问并非是多态的
 * 	1.一旦你了解了多态机制,可能就会开始认为所有事物都可以多态地发生.然而,只有普通方法调用是可以多态的.
 * 例如: 如果你直接访问某个域,这个访问就将在编译期进行解析.
 * 	2.当Sub对象转型为Super引用时,任何域访问操作都将由编译期解析,因此不是多态的.在本例中,为Super.field 
 * 和Sub.field分配了不同的存储空间.这样,Sub 实际上包含了两个称为 field的域.因此,为了得到Super.field,
 * 必须显式地指明Super.field.
 * 	3.尽管这看起来好像会成为一个令人混淆的额问题,但是在实践中,他实际上从来不会发生
 * 		因为:
 *      	1.你通常会将所有的域设置成field,从此不能直接访问他们,其副作用就是只能调用方法来访问.
 *      	2.你可能不会对基类中的域和导出类中的域赋予相同的名字.
 * @author admin
 *
 */
public class FieldAccess {
	public static void main(String[] args) {
		Super sup = new Sub();
		System.out.println("super.field = " + sup.field + 
				", sub.getField() = " + sup.getField());
		
		Sub sub = new Sub();
		System.out.println("sub.field = " + sub.field + 
				", sub.getField() = " + sub.getField() + 
				",sub.getSuperField() = " + sub.getSuperField());
		
		/**
		 * super.field = 0, sub.getField() = 1
			sub.field = 1, sub.getField() = 1,sub.getSuperField() = 0
		 */
	}
}
