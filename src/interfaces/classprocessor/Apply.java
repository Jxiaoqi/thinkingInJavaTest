package interfaces.classprocessor;

import java.util.Arrays;
import static util.Print.*;

/**
 * 完全解耦------策略设计模式
 * 		1.只要一个方法操作的是类而非接口,那么你就只能使用这个及其子类.如果你想要将这个方法
 * 应用于不同在此继承结构中的某个类,你就会触霉头.接口在很大程度上放宽了这种限制,因此,它使得我们可以
 * 编写可复用性更好的代码.
 * 		2.Apply.process()方法可以接受任何类型的Processor,并将其应用于一个Object对象上,
 * 然后打印结果.像本例这样,创建一个能够根据所传递的对象的不同而具有不同行为的方法,被称为   "策略设计模式".
 * 这类方法包含所要执行的算法中固定不变的部分,而"策略"包含变化的部分. 策略就是传递进去的参数对象,它包含
 * 要执行的代码.这里,Processor对象就是一个策略,在main()方法中可以看到三种不同类型的策略应用到了
 * String 类型的s对象上.
 * @author admin
 *
 */
class Processor {
	public String name() {
		return getClass().getSimpleName();
	}
	
	Object process(Object input) { return input; }
}

class Upcase extends Processor {
	@Override
	String process(Object input) {
		return ((String)input).toUpperCase(); 
	}
}

class Downcase extends Processor {
	@Override
	String process(Object input) {
		// TODO Auto-generated method stub
		return ((String)input).toLowerCase();
	}
}

class Splitter extends Processor {
	@Override
	String process(Object input) {
		// TODO Auto-generated method stub
		return Arrays.toString(((String)input).split(" "));
	}
}

public class Apply {
	public static void process(Processor p, Object s) {
		print("Using Processor " + p.name());
		print(p.process(s));
	}
	public static String s = 
			"Disagreement with beliefs is by definition incorrect";
	public static void main(String[] args) {
		process(new Upcase(), s);
		process(new Downcase(), s);
		process(new Splitter(), s);
		
		/**
		 * Using Processor Upcase
			DISAGREEMENT WITH BELIEFS IS BY DEFINITION INCORRECT
			Using Processor Downcase
			disagreement with beliefs is by definition incorrect
			Using Processor Splitter
			[Disagreement, with, beliefs, is, by, definition, incorrect]
		 */
	}
}
