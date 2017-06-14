package interfaces.interfaceprocessor;

import static util.Print.*;

public class Apply {
	public static void process(Processor p, Object input) {
		print("Using processor " + input);
		print(p.process(input));
	}
}
