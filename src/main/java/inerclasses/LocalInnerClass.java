package inerclasses;

import static util.Print.*;

/**
 * 局部内部类
 * 		1.可以在代码里创建内部类,典型的方式就是在一个方法体的里边创建.
 * 	局部内部类不能有访问说明符,因为它是外围类的一部分,但是它可以访问当前代码块内的常量,
 * 以及外围类的所有成员(count).----局部内部类与匿名内部类的比较.
 * 		2.为什么需要局部内部类呢?	
 * 			我们需要一个已命名的构造器,或者需要重载构造器,而匿名内部类只能用于实例初始化.
 * 		使用局部内部类而不是用匿名内部类的另一个理由就是:需要 不止一个该内部类对象.
 * @author admin
 *
 */
interface Counter {
	int next();
}

public class LocalInnerClass {
	private int count = 0;
	
	Counter getCounter(final String name) {		//局部类
		//a local inner class	
		class LocalCounter implements Counter {
			//local inner class can have a constructor
			public LocalCounter() {
				print("LocalCouter");
			}
			@Override
			public int next() {
				printnb(name);		//access local final
				return count++;
			}
			
		}
		
		return new LocalCounter();
	}
	
	Counter getCounter2(final String name) {
		return new Counter() {
			//annoymous inner class cannot hava named
			//constructor, only an instance initializer
			{
				print("Counter");
			}
			
			@Override
			public int next() {
				printnb(name);		//access local final
				return count++;
			}
		};
	}
	
	public static void main(String[] args) {
		LocalInnerClass lic = new LocalInnerClass();
		Counter 
			c1 = lic.getCounter("Local inner"),
			c2 = lic.getCounter2("Anonymous inner");
		for (int i = 0; i < 5; i++) {
			print(c1.next());
		}
		for (int i = 0; i < 5; i++) {
			print(c2.next());
		}
		
		
		/**
		 * LocalCouter
Counter
Local inner0
Local inner1
Local inner2
Local inner3
Local inner4
Anonymous inner5
Anonymous inner6
Anonymous inner7
Anonymous inner8
Anonymous inner9
		 */
	}
}
