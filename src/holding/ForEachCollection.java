package holding;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * ForEach 与迭代器
 * 		这段代码暂时了能够与foreach一起工作是所有Collection对象的特性.
 * @author admin
 *
 */
public class ForEachCollection {
	public static void main(String[] args) {
		Collection<String> cs = new LinkedList<String>();
		Collections.addAll(cs,
				"Take the long way home".split(" "));
		for (String s : cs) 
			System.out.print("'" + s + "' ");
	}
	

}
