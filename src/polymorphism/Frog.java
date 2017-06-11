package polymorphism;

import static util.Print.*;

//特征
class Characteristic {
	private String s;
	public Characteristic(String s) {
		this.s = s;
		print("Creating Characteristic " + s);
	}
	
	protected void dispose() {
		print("disposing Characteristic " + s);
	}
}
//描述
class Description {
	private String s;
	public Description(String s) {
		this.s = s;
		print("Creating Description " + s);
	}
	
	protected void  dispose() {
		print("disposing Description " + s);
	}
}
//生物
class LivingCreature {
	private Characteristic p =
			new Characteristic("is alive");
	private Description d = 
			new Description("Basic Living Creature");
	
	public LivingCreature() {
		print("LivingCreature()");
	}
	
	protected void  dispose() {
		print("disposing LivingCreature ");
		d.dispose();
		p.dispose();
	}
}

class Animal extends LivingCreature {
	private Characteristic p = 
			new Characteristic("has heart");
	private Description d = 
			new Description("Animal not vegetable");
	
	public Animal() {
		print("Animal()");
	}
	
	@Override
	protected void dispose() {
		d.dispose();
		p.dispose();
		super.dispose();
	}
}
//两栖动物
class Amphibian extends LivingCreature {
	private Characteristic p =
			new Characteristic("can live in water");
	private Description d =
			new Description("Both water and land");
	
	public Amphibian() {
		print("Amphibian()");
	}
	
	@Override
	protected void dispose() {
		d.dispose();
		p.dispose();
		super.dispose();
	}
}

/**
 * 多态： 继承与清理
 * 		1.通过组合和继承方法来创建新类时，永远不必担心对象的清理问题，子对象通常都会留给垃圾回收器进行处理。
 * 		2.如果确实遇到清理的问题，那么必须用心为新类创建dispose()方法，如果我们有其他作为垃圾回收一部分的特殊清理
 * 动作，就必须在导出类中覆盖dispose()方法。
 * 		3.当覆盖被继承类的dispose方时，务必调用基类版本的dispose()方法，否则，基类的清理动作就不会发生。
 * 		4.万一某个子对象依赖于其他对象，销毁的顺序应该和初始化顺序相反。
 * 			1.对于字段，则意味着与生命顺序相反（因为字段的初始化是按照生命的顺序进行的。）
 * 			2.对于基类，应该首先对其导出类进行清理，然后才是基类。因为导出类的清理可能会调用基类中的某些方法，所以
 * 需要使积累的构件仍起作用而不应过早地销毁她们。
 * @author 贾玉豪
 *
 */
public class Frog extends Amphibian {
	private Characteristic p =
			new Characteristic("Crocks");
	private Description d =
			new Description("Eats Bugs");
	
	public Frog() {
		print("Frog()");
	}
	
	@Override
	protected void dispose() {
		d.dispose();
		p.dispose();
		super.dispose();
	}
	
	public static void main(String[] args) {
		Frog frog = new Frog();
		print("Bye Bye");
		frog.dispose();
		
		/**
		 * Creating Characteristic is alive
			Creating Description Basic Living Creature
			LivingCreature()
			Creating Characteristic can live in water
			Creating Description Both water and land
			Amphibian()
			Creating Characteristic Crocks
			Creating Description Eats Bugs
			Frog()
			Bye Bye
			disposing DescriptionEats Bugs
			disposing Characteristic Crocks
			disposing DescriptionBoth water and land
			disposing Characteristic can live in water
			disposing LivingCreature 
			disposing DescriptionBasic Living Creature
			disposing Characteristic is alive
		 */
	}
}
