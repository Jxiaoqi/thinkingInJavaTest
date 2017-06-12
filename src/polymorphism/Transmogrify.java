package polymorphism;

/**
 * 状态模式
 * 多态:  用继承进行设计
 * 		1.当我们使用现成的类来建立新类是时,如果首先考虑使用继承技术,反倒会加重我们的设计负担,
 * 使事情变得不必要复杂起来.
 * 		2.更好的方式是首先选择"组合",尤其是不能十分确定应该使用哪一种类型时.组合不会强制我们的程序
 * 进入继承的层次结构中.而且,组合更加灵活,因为它可以动态选择类型(因为也选择了行为);相反,继承在编译时
 * 就需要知道确切类型.
 * 		3.此例子中:Stage对象包含了一个Actor引用,而Actor被初始化为HappyActor对象.这意味着
 * performPlay()会产生某种特殊行为.   既然引用在运行时可以和另个一对象重新绑定起来,所以SadActor
 * 对象的引用可以在actor中被替代,然后由PerformPlay()所产生的行为也随之改变.这样一来,  我们在运行
 * 期间获得了------动态灵活性,这也称作为-----状态模式. 于此相反,我们不能在 运行期间决定继承不同对象,
 * 因为它 要求在编译期间确定下来.	
 * 		4.一条通用的准则是:" 用继承表达为间的差异, 并用字段表达状态上的变化"; 在本例中,两者都用到了:
 * 通过继承得到了两个不同的类,用于表达actor()方法的差异; 而Stage通过运用组合使自己的状态发生变化.在这种
 * 情况下,这种状态的变化也就改变了行为的变化.
 * @author admin
 *
 */
class Actor {
	public void act() {}
}

class HappyActor extends Actor {
	@Override
	public void act() {
		System.out.println("HappyActor");
	}
}

class SadActor extends Actor {
	@Override
	public void act() {
		System.out.println("SadActor");
	}
}

class Stage {
	private Actor actor = new HappyActor();
	public void change() {
		actor = new SadActor();
	}
	
	public void performPlay(){
		actor.act();
	}
	
}

public class Transmogrify {			//Transmogrify 使变形状,变奇形怪状.
	public static void main(String[] args) {
		Stage stage = new Stage();
		stage.performPlay();
		stage.change();
		stage.performPlay();
		
		/**
		 * HappyActor
			SadActor
		 */
	}
}
