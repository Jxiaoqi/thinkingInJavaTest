package polymorphism;

import static util.Print.*;

/**
 * 多态 ---构造器内部的多态方法的行为
 * 		1.构造器调用的层次结构带来了一个有趣的两难问题: 如果在一个构造器的内部调用正在
 * 构造的对象的某个动态绑定方法,会发生生么情况呢?
 * 		2.在一般的方法内部,动态绑定的调用是在运行时才决定的,因为对象无法知道对象属于那个
 * 方法的类,还是属于那个类的导出类.
 * 		3.如果要调用构造器内部的一个动态绑定方法,就要用到那个方法的被覆盖后的定义.然而,
 * 这个调用的的效果可能想当难以预料,因为被覆盖的方法在对象完全构造之前就会被调用.这可能造成一些
 * 难以发现的隐藏效果.
 * 		4.从概念上讲,构造器的工作实际上是构建对象.在任何构造器内部,整个对象可能只是部分形成----
 * 我们只知道基类对象已经进行初始化.如果构造器只是在构建对象过程中的一个步骤,并且该对象所属的类
 * 是从这个构造器所属的类导出的,那么导出部分在当前构造器正在被调用的时候仍旧是没有被初始化的.然而,
 * 一个动态绑定的方法调用却会向外深入到继承层次结构内部,他可以调用导出类里的方法.如果我们是在构造器内部
 * 这样做,那么就可能会调用某个方法,而这个方法所操纵的成员可能还未进行初始化----这肯定会招致灾难.
 * 		5.Glyph.draw()方法设计为将要被覆盖,这种覆盖是在RoundGlyph中发生的.但是Glyph构造器
 * 会调用该方法,结果导致了对RoundGlyph.draw()方法的调用,这看起来似乎是我们的目的.但是如果看到输出
 * 结果,我们会发现当Glyph的构造器调用draw()时,radius不是默认初始值1,而是0.
 * 		6.初始化的实际过程是:
 * 			1.在任何其他事物发生之前,将分配给对象的存储空间初始化为二进制的零.(基本数据类型为0,引用类型位null)
 * 			2.如前所述那样调用构造器.此时,调用被覆盖后的方法 draw()(要在调用RoundGlyph构造器之前调用)
 * 		由于步骤1的缘故,我们发现此时radius的值为0
 * 			3.按照声明顺序调用成员的初始化方法(成员对象的初始化)
 * 			4.调用导出类的构造器主体.
 * 		7.这样做的有点:那就是所有东西都至少被初始化为零(或者某些特殊数据类型中与零等价的值),而不仅仅是留作垃圾.
 * 其中包括通过"组合"嵌入一个类内部的对象引用,其值为null,
 * 		8.编写构造器有一个有效的准则:"用尽可能简单的方法使对象进入正常状态;如果可以的话,避免调用其他方法."在
 * 构造器内唯一能够完全调用的方法是基类中的final方法(也适用于final方法,他们自动是  final的).这些方法不能被
 * 覆盖,因为也就不会出现上述令人惊讶的问题.
 * 
 * 	
 * @author admin
 *
 */
class Glyph {
	void draw() { print("Glyph.draw()");}
	public Glyph() {
		print("Glyph() before draw()");
		draw();
		print("Glyph() after draw()");
	}
}

class RoundGlyph extends Glyph {
	private int redius = 1;
	public RoundGlyph(int r) {
		redius = r;
		print("RoundGlyph.RoundGlyph(), radius = " + redius);
	}
	
	@Override
	void draw() {
		print("RoundGlyph.draw(), radius = " + redius);
	}
}


public class PolyConstructors {
	public static void main(String[] args) {
		new RoundGlyph(5);
		
		/**
		 * Glyph() before draw()
		RoundGlyph.draw(), radius = 0
		Glyph() after draw()
		RoundGlyph.RoundGlyph(), radius = 5

		 */
	}
}
