package inerclasses;

/**
 * 接口内部的类:
 * 		1.正常情况下,不能在接口内部置任何代码,但嵌套类可以作为接口的一部分.
 * 你放到接口中的任何类都是public和static的.因为类是static的,只是将嵌套类
 * 置于接口的命名空间内,这并不违反接口的规则.你甚至可以在内部类中实现其外围接口.
 * 		2.如果你想要创建某些公共代码,使得它们可以被某个接口的所有不同实现所公用,那么
 * 使用接口内部的嵌套类会显得更方便.
 * 		3.该代码生成了一个独立的类ClassInterface.Test.class
 * @author admin
 *
 */
//{main:ClassInterface$Test}
public interface ClassInterface {
	void howdy();
	class Test implements ClassInterface {

		@Override
		public void howdy() {
			System.out.println("Howdy!");
		}
		
		public static void main(String[] args) {
			new Test().howdy();
		}
	}

}
