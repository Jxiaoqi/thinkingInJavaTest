package inerclasses;

/**
 * 内部类与向上转型:
 * 		1.当讲内部类向上转型为基类,尤其是转型为一个接口的时候,内部类就有了用武之地.
 * *(从实现了某个接口的对象,得到对此接口的引用,与  向上转型为这个对象的基类,实质上效果是一样的.)
 * 	这是因为此内部类  ----某个接口的实现---能够完全不可见,并且不可用.所得到的只是指向基类或接口的
 * 引用,所以能够很方面地隐藏细节.
 * 		2.private内部类 给类的设计者提供了一种途径,通过这种方式可以完全阻止任何依赖于类型的编码,
 * 并且完全隐藏了实现细节. 此外,从客户端程序员的角度来看,由于不能访问任何新增加,原本不属于公共接口
 * 的方法,所以扩展接口是没有价值的.
 * @author admin
 *
 */
class Parcel4 {
	private class PContents implements Contents {
		private int i = 11;
		@Override
		public int value() {
			return i;
		}
	}
	protected class PDestination implements Destination {
		private String label;
		public PDestination(String whereto) {
			label = whereto;
		}
		@Override
		public String readLabel() {
			return label;
		}
	}
	public Destination destination(String s) {
		return new PDestination(s);
	}
	public Contents contents() {
		return new PContents();
	}
	
}

public class TestParcel4 {
	public static void main(String[] args) {
		Parcel4 p = new Parcel4();
		Contents c = p.contents();
		Destination d = p.destination("Tasmina");
		
		//The type Parcel4.PContents is not visible
		//Illegal --- can't access private class
		//!Parcel4.PContents pc = p.new PContents();
	}
}
