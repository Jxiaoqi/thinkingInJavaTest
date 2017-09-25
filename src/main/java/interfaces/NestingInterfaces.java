package interfaces;


/**
 * 嵌套接口:
 * 		1.在类中嵌套接口的语法是相当显而易见的,就像非嵌套接口一样,可以拥有public 和"包访问"两种可视性
 * 		2.
 * @author admin
 *
 */
class A {
	interface B {
		void f();
	}
	public class BImp implements B {
		@Override
		public void f() {}
	}
	private class BImp2 implements B {
		public void f() {}
	}
	
	public interface C {
		void f();
	}
	class CImp implements C {
		public void f(){}
	}
	private class CImp2 implements C {
		public void f() {}
	}
	
	private interface D {
		void f();
	}
	private class DImp implements D {
		public void f() {}
	}
	public class DImp2 implements D {
		public void f() {}
	}
	
	public D getD() { return new DImp2();} 
	private D dRef;
	public void receiveD(D d) {
		dRef = d;
		dRef.f();
	}
	
}	

interface E {
	interface G {
		void f();
	}
	//Redundant "public" 多余的public
	public interface H {
		void f();
	}
	
	void g();
	//The interface member type I can only be public  , Can't be private within an interface
	//!private interface I {}
}

public class NestingInterfaces {
	public class BImp implements A.B {

		@Override
		public void f() {}
	}
	
	public class CImp implements A.C {

		@Override
		public void f() {}
	}
	
	//The type A.D is not visible  Can't implements a private interface except
	//class DImp implements A.D {
	//	@Override
	//	public void f() {	}
	//}
	class EImp implements E {
		@Override
		public void g() {}
	}
	
	class EGImp2 implements E.G {
		@Override
		public void f() {}
	}
	
	class EImp2 implements E {
		public void g() {}
		class EG implements E.G {
			public void f() {}
		}
	}
	
	public static void main(String[] args) {
		A a = new A();
		//can't acess A.D
		//!A.D = a.getD();
		// Doesn't return anthing but A.D
		//!A.DImp2 = a.getD();
		//Can't access a member of the interface
		//!a.getD().f();
		//only another A can do anything with getD()
		A a2 = new A();
		a2.receiveD(a.getD());
		
		
		
	}
}


