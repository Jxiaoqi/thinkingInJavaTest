package inerclasses;

/**
 * 嵌套类:
 * 		1.在每个类中写一个main()方法,用来测试这个类.这样做有一个缺点,那就是必须带着
 * 已经编译过的额外代码.如果这对你是个麻烦,那么可以使用嵌套类来防止测试代码.
 * 		2.这生成了一个独立的类TestBed$Tester.class .可以使用这个类来做测试,但是不必
 * 在发布产品中包含它,在将产品打包前可以简单地删除TestBed$Tester.class
 * @author admin
 *
 */
public class TestBed {
	public void f() { System.out.println("f()");}
	public static class Tester {
		public static void main(String[] args) {
			TestBed t = new TestBed();
			t.f();
			
			//f()
		}
	}
}
