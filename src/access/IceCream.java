package access;

class Sundae{
	private Sundae(){	}
	static Sundae makeSundae(){
		return new Sundae();
	}
}
public class IceCream{
	public static void main(String[] args) {
		//!Sundae x = new Sundae();  	//不能访问拥有private 权限的额构造方法创建对象.
		Sundae x = Sundae.makeSundae();
	}
}