package inerclasses;

import static util.Print.*;

/**
 * 匿名类----工厂方法
 * 		1.现在用于Implemetion1和2 的构造器都可以是private的,并且没有任何必要去创建必要的额工厂类.
 * 		2.你经常只需要创建单一的工厂对象,因此在本例中使用匿名内部类来改进.
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

class ServiceImplemetion1 implements Service {

	private ServiceImplemetion1() {	}
	@Override
	public void method1() {
		print("Implemetion1 method1");
	}

	@Override
	public void method2() {
		print("Implemetion1 method2");
	}
	public static ServiceFactory factory = 
			new ServiceFactory() {
				
				@Override
				public Service getService() {
					return new ServiceImplemetion1();
				}
			};
}

class ServiceImplemetion2 implements Service {

	@Override
	public void method1() {
		print("Implemetion2 method1");
	}

	@Override
	public void method2() {
		print("Implemetion2 method2");
	}
	
	public static ServiceFactory factory = 
			new ServiceFactory() {
				
				@Override
				public Service getService() {
					return new ServiceImplemetion2();
				}
			};
}

public class Factories {
	public static void consumer(ServiceFactory fact) {
		Service s = fact.getService();
		s.method1();
		s.method2();
	}
	
	public static void main(String[] args) {
		consumer(ServiceImplemetion1.factory);
		consumer(ServiceImplemetion2.factory);
		
		/**
		 * Implemetion1 method1
Implemetion1 method2
Implemetion2 method1
Implemetion2 method2
		 */
	}
}
