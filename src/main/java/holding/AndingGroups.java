package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 添加一组元素
 * 		1.在java.util包中的Arrays 和  Collections类中有很多实用的方法，
 * 可以在Collection中添加一组元素。
 * 			Arrays.asList()方法接受一个数组或是一个用逗号分隔的元素列表（使用可变参数），并将其
 * 转换为一个List对象。
 * 			Collection.addAll()方法接受一个Collection对象，以及一个数组或是一个用逗号分隔的列表。
 * 讲元素添加到Collection中。
 * 		2.Collection.addAll() 方法运行起来要快得多，而且构建一个不包含元素的Collection,然后
 * 调用Collections.addAll()这种方式很方便，（Collection.addAll() 会产生空指针异常）
 * 		3.可以直接使用 Arrays.asList()的输出，将其当做List,但是在这种情况下，其底层表示的是数组，
 * 因此不能调整尺寸。当用add()和delete()方法在这种列表中添加或删除元素时，就有可能引发去改变数组尺寸的尝试，
 * 因为你将在 运行时获得"Unsupported Operation"错误。
 * @author 贾玉豪
 *
 */
public class AndingGroups {
	public static void main(String[] args) {
		Collection<Integer> collection = 
				new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		Integer[] moreInts = {6, 7, 8, 9, 10};
		collection.addAll(Arrays.asList(moreInts));
		Collections.addAll(collection, 11, 12, 13, 14);
		Collections.addAll(collection, moreInts);
		
		List<Integer> list = Arrays.asList(16, 17, 18, 19 ,20);
		list.set(1, 99);
		//list.add(21);		//java.lang.UnsupportedOperationException
	}
}
