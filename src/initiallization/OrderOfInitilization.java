package initiallization;

import static util.Print.*;


class Window{
	public Window(int marker) {
		print("Window(" + marker + ")");
	}
}

class House{
	Window w1 = new Window(1);		//Before Constructor
	House(){
		//show that we are in constrctor
		print("House()");
		w3 = new Window(3);			//Reinilialize w3
	}
	Window w2 = new Window(2);		//after constructor
	void f(){
		print("f()");
	}
	Window w3 = new Window(3);		//at end
	
}
/**
 * 	变量的初始化.....
 * 	在类的内部,成员变量的定义顺序决定了初始化的顺序.即使,变量定义散布于方法定义之间,
 * 它们仍旧会在任何方法(包括构造器)被调用之前得到初始化		成员变量   >方法(包括构造方法)
 * @author admin
 *
 */
public class OrderOfInitilization {
	public static void main(String[] args) {
		House house = new House();
		house.f();
		
		/**
		 * Window(1)
			Window(2)
			Window(3)
			House()
			Window(3)
			f()

		 */
	}
}
