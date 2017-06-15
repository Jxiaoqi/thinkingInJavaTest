package interfaces;

import static util.Print.*;

/**
 * 接口与工厂  :  工厂设计模式
 * 		1.接口是实现多重继承的途径,而生成遵循某个接口的对象的典型方式就是---工厂方法设计模式.
 * 这与直接调用构造方法不同,我们在工厂对象上调用的是创建方法,而该工厂对象将生成接口的某个实现的对象
 * 理论上,通过这种方式,我们的代码将完全实现与接口的实现分离,这就使得我们可以透明底将某个实现替换为
 * 另一个实现.
 * 		2.如果不是工厂方法,你的代码必须在某处指定将要创建的Service 的确切类型,以便调用合适的
 * 构造器.
 * 
 * @author admin
 *
 */
interface Service {
	void method1();
	void method2();
}

interface ServiceFactory {
	Service getService();
}

class Implementation1 implements Service {

	Implementation1() {	}		//package access
	@Override
	public void method1() {
		print("Implementation1 method1");
	}

	@Override
	public void method2() {
		print("Implementation2 method2");
	}
	
}

class Implementation1Factory implements ServiceFactory {
	public Service getService() {
		return new Implementation1();
	}
}

class Implementation2 implements Service {

	public Implementation2() {	}		//package access
	@Override
	public void method1() {
		print("Implementation2 method1");
	}

	@Override
	public void method2() {
		print("Implementation2 method2");
	}
	
}

class Implementation2Factory implements ServiceFactory {

	@Override
	public Service getService() {
		return new Implementation2();
	}
	
}


public class Factories {
	public static void serviceConsumer(ServiceFactory fact) {
		Service s = fact.getService();
		s.method1();
		s.method2();
	}
	
	public static void main(String[] args) {
		serviceConsumer(new Implementation1Factory());
		serviceConsumer(new Implementation2Factory());
		
		/**
		 * Implementation1 method1
			Implementation2 method2
			Implementation2 method1
			Implementation2 method2
		 */
	}
}
