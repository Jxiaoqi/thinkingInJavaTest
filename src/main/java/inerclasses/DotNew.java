package inerclasses;

/**
 * 使用.new创建内部对象
 * 		1.有时你可以想要告知某些其他对象,去创建其某个内部类的对象.要实现此目的,
 * 你必须在new表达式中提供对其他外部类对象的引用
 * 		2.要想直接创建内部类的对象,你不能按照你想象的方式,去引用外部类对象的名字DotNew,
 * 而是必须使用外部类的对象来创建该内部类对象,就像dt.new Inner().这也解决了内部类名字作用于的
 * 问题,因此你不必声明(实际上你不用声明)dn.new DotNew.Inner()
 * @author admin
 *
 */
public class DotNew {
	
	public class Inner {}
	
	public static void main(String[] args) {
		DotNew dn = new DotNew();
		DotNew.Inner in = dn.new Inner();
	}
}
