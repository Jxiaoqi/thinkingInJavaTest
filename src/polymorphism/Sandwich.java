package polymorphism;

import static util.Print.*;

class Meal {
	public Meal() { print("Meal()");	}
}

class Bread { 
	public Bread() { print("Bread()");}
}

class Cheese {
	public Cheese() { print("Cheese()");	}
}

class Lettuce {
	public Lettuce() { print("Lettuce()");	}
}

class Lunch extends Meal {
	public Lunch() { print("Lunch()");	}
}

class PortableLunch extends Lunch {
	public PortableLunch() { print("PortableLunch()");	}
}

/**
 * 构造器和多态----构造器的调用顺序
 * 		1.基类的构造器总是在导出类的构造过程中被调用，而且按照继承层次逐渐向上链接，以使每个基类的构造器
 * 都能得到调用，---检查对象是否被正确地构造。
 * 		2.导出类只能访问它自己的成员，不能访问基类中的成员（基类中的成员通常是private的）。 只有基类的
 * 构造器才具有恰当的知识和权限来对自己的元素进行初始化，因此，必须令所有构造器都得到调用，否则就不可能正确构造
 * 完整对象。这正是编译器为什么要强制每个导出类部分都必须调用构造器的原因。
 * 		3.在导出类的构造器主体中，如果没有明确指定调用某个基类构造器，它就会“默默”地调用默认构造器。如果不存在
 * 默认构造器，编译就会报错（若摸个类没有构造器，编译器会自动生成一个默认构造器。）
 * 		4.这一复杂对象调用构造器遵循下面的顺序：
 * 			1.调用基类构造器。这个步骤会不断地反复递归下去，首先是构造这种层次结构的根，然后是下一层导出类。
 * 			2.按生命顺序调用成员的初始化方法。
 * 			3.调用导出类构造器主体。
 * 		5.Frog独享拥有自己的成员对象,并且知道他们应该存活多久(只要Frog存活着),因此Frog对象知道何时调用
 * dispose()去释放其成员对象.
 * @author 贾玉豪
 *
 */
public class Sandwich extends PortableLunch {
	private Bread d = new Bread();
	private Cheese c = new Cheese();
	private Lettuce l = new Lettuce();
	
	public Sandwich() {
		print("Sandwich()");
	}
	
	public static void main(String[] args) {
		new Sandwich();
	}
	
	/**
	 * Meal()
Lunch()
PortableLunch()
Bread()
Cheese()
Lettuce()
Sandwich()
	 */
}
