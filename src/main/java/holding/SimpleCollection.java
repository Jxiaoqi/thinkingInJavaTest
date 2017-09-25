package holding;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Collection接口概括了序列的概念----一组存放对象的方式。
 * @author 贾玉豪
 *
 */
public class SimpleCollection {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Collection<Integer> collection = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			collection.add(i);   		//auto boxing
		}
		for (Integer i : collection) {
			System.out.print(i + " ,");
		}
	}

}
