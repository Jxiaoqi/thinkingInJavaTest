package interfaces;

/**
 *  组合接口时的名字冲突
 *  	在打算组合的不同接口中使用相同的方法名通常会造成代码可读性的混乱.避免
 * @author admin
 *
 */
interface I1 { void f();}
interface I2 { void f(int i);}
interface I3 { int f();}
class C { public int f() { return 1;}}

class C2 implements I1,I2 {
	@Override
	public void f(int i) {}
	@Override
	public void f() {}		//overload
}

class C3 extends C implements I2 {
	@Override
	public void f(int i) {	}		//overload
}

class C4 extends C implements I3 {
	@Override
	public int f() { return 1;}		//overload	
}

//class C5 extends C implements I1{}			//The return types are incompatible for the inherited methods I1.f(), C.f()
	
//interface I4 extends I1, I3 {}     ///The return types are incompatible for the inherited methods I1.f(), I3.f()

public class InterfacaeCollision {
	
}
