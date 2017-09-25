package interfaces.interfaceprocessor;

import java.util.Arrays;

/**
 * 复用代码的第一种方式:  客户端程序员遵循该接口来编写他们自己的类.
 * @author admin
 *
 */
public abstract class StringProcessor implements Processor {
	@Override
	public String name() {
		return getClass().getSimpleName();
	}
	
	public abstract String process(Object input);
	
	public static String s = 
			"If she weight the same as duck, she's made of wood";
	
	public static void main(String[] args) {
		Apply.process(new Upcase(), s);
		Apply.process(new Downcase(), s);
		Apply.process(new Splitter(), s);
		
		/**
		 * Using processor If she weight the same as duck, she's made of wood
			IF SHE WEIGHT THE SAME AS DUCK, SHE'S MADE OF WOOD
			Using processor If she weight the same as duck, she's made of wood
			if she weight the same as duck, she's made of wood
			Using processor If she weight the same as duck, she's made of wood
			[If, she, weight, the, same, as, duck,, she's, made, of, wood]

		 */
	}
}

class Upcase extends StringProcessor {
	@Override
	public String process(Object input) {
		return ((String)input).toUpperCase();
	}
}

class Downcase extends StringProcessor {
	@Override
	public String process(Object input) {
		return ((String)input).toLowerCase();
	}
}

class Splitter extends StringProcessor {
	@Override
	public String process(Object input) {
		return Arrays.toString(((String)input).split(" "));
	}
	
}
