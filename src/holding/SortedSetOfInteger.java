package holding;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * TreeSet 来生成排序的结果,来代替HashSet
 * @author admin
 *
 */
public class SortedSetOfInteger {
	public static void main(String[] args) {
		Random rand = new Random(47);
		SortedSet<Integer> intSet = new TreeSet<Integer>();
		for (int i = 0; i < 1000; i++) 
			intSet.add(rand.nextInt(30));
		System.out.println(intSet);
		
		/**
		 * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29]
		 */
	}
}
