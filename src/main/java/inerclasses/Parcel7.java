package inerclasses;

/**
 * 匿名内部类
 * 		1.Contents()方法将返回值的生成和这个返回值的类的定义结合在一起.
 * 		2.这种语法指的是: 创建一个继承自Contents的匿名类的对象.通过new表达式返回的引用被
 * 		3.在该匿名内部类中使用了默认的构造器来生成Contents
 * 自动向上转型为对Contents的引用.
 * @author admin
 *
 */
public class Parcel7 {
	
	public Contents contents() {
		return new Contents() {		//Insert a class defination
			private int i = 11;
			@Override
			public int value() {
				return i;
			}
		};
	}
	
	public static void main(String[] args) {
		Parcel7 p = new Parcel7();
		Contents c = p.contents();
	}

}
