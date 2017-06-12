package polymorphism;

import static util.Print.*;

/**
 * 继承与清理---引用计数,清除
 * 		1.如果一个成员对象存在于其他一个或多个对象共享的情况,问题就变得复杂了,你就
 * 不能简单地假设你可以调用dispose()了.在这种情况下,也就必须使用  引用计数 来跟踪
 * 仍旧访问着共享对象的对象数量了.
 * 		2. static long counter跟踪所创建的share的实例的数量,还可以为id提供
 * 数值.counter的类型时long而不是int,这样可以防止溢出. id是final的,因为我们不希望
 * 它的值在对象生命周期中被改变.
 * 	    3.在将一个共享对象附着到类上时,必须记住调用addRef(),但是dispose方法将跟踪引用数,
 * 并决定何时执行清理.
 * 
 * @author admin
 *
 */
class Share {
	private int refCount = 0;
	private static long counter = 0;
	private final long id = counter++;
	public Share() {
		print("Creating " + this);
	}
	
	public void addRef(){ refCount++; }
	
	protected void  dispose() {
		if (--refCount == 0) {
			print("Disposing " + this);
		}
	}
	
	@Override
	public String toString() {
		return "Share " + id;
	}
}

class Composing {
	private Share share;
	private static long counter = 0;
	private final long id = counter++;
	public Composing(Share share) {
		print("Creating " + this);
		this.share = share;
		this.share.addRef();
	}
	
	protected void  dispose() {
		print("disposing " + this);
		share.dispose();	
	}
	
	@Override
	public String toString() {
		return "Composing " + id;
	}
	
}

public class ReferenceCounting {
	public static void main(String[] args) {
		Share share = new Share();
		Composing[] composing = { new Composing(share),
				new Composing(share), new Composing(share),
				new Composing(share), new Composing(share),
				new Composing(share), new Composing(share)
		};
			
		for(Composing c : composing){
			c.dispose();
		}
	}
}
