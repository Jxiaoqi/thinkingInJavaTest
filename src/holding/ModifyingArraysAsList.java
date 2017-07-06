package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Arrays.asList() 和 new ArrayList<>(Collection c)方法比较
 * 		第一种情况:  Arrays.asList()的输出被传递给了ArrayList()的构造器,
 * 这将创建一个引用ia的元素的ArrayList(),因此打乱这些引用不会修改该数组.
 * 		第二种情况:  直接使用Arrays.asList(ia)产生的List的结果,这种打乱就会
 * 修改ia的顺序.
 * 		总结:  意识到Arrays.asList()产生的List对象会使用底层数组 作为其物理实现
 * 是很重要的.只要你执行的操作会修改这个List,并且你不想原来的数组被修改,那么你就应该在
 * 另一个容器中创建一个副本.
 * @author admin
 *
 */
public class ModifyingArraysAsList {
	public static void main(String[] args) {
		Random rand = new Random(47);
		Integer[] ia = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		List<Integer> list1 = 
				new ArrayList<Integer>(Arrays.asList(ia));
		System.out.println("Before Shuffled: " + list1);
		Collections.shuffle(list1, rand);
		System.out.println("After Shuffled: " + list1);
		System.out.println("array: " + Arrays.toString(ia));
		
		System.out.println();
		
		List<Integer> list2 = Arrays.asList(ia);
		System.out.println("Before Shuffled: " + list2);
		Collections.shuffle(list2, rand);
		System.out.println("After Shuffled: " + list2);
		System.out.println("array: " + Arrays.toString(ia));
	}
}
