package polymorphism;

/*
 *	多态:  向下转型  和  运行时类型识别 RTTI
 *		1.由于向上转型(在继承层次结构中向上移动)会丢失具体的类型信息,所以我们就想,通过
 *	向下转型----也就是在继承层次结构中向下移动---应该能获取类型信息.
 *		2.然而,我们知道向上转型是安全的,因为基类不会具有大于导出类的接口.因此,我们通过
 *	基类接口发送的信息保证都能被接受.
 *		3.RTTI: 在java中,所有转型都会得到检查! 如果想访问Moreuseful对象的扩展接口,
 *	就可以尝试进行向下转型. 如果所转类型是正确的类型,那么转型成功;否则, 就会返回一个ClassCastException异常.
 */		
class Useful {
	public void f() {}
	public void g() {}
}

class MoreUseful extends Useful {
	public void f() {}
	public void g() {}
	public void u() {}
	public void v() {}
	public void w() {}
}

public class RTTI {
	public static void main(String[] args) {
		Useful[] x = {
				new Useful(),
				new MoreUseful()
		};
		x[0].f();
		x[1].f();
		//Compile time : method not found in Useful
		//!x[1].u();	The method u() is undefined for the type Useful  
		((MoreUseful)x[1]).u();		//Downcast /RTTI
		((MoreUseful)x[0]).u();		//Exception thrown
		
	}
}
