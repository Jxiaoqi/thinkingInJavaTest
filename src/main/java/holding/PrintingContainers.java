package holding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import static util.Print.*;

/**
 * 容器的打印
 * 		1.使用Arras.toString来产生数组的打印,但是打印容器无需任何帮助.
 * 		2.Collection打印出来的内容用方括号括住,每个元素用逗号分隔.Map则用大括号括住,键与值
 * 用等号联系.
 * 		3.ArrayList 和 LinkedList都是List类型,从输出可以看出,他们都按照被插入的顺序保存元素,
 * 两者的不同之处不仅在于执行某些类型的操作时的性能,而且LinkedList包含的操作也多于ArrayList.
 * 		4. HashSet, TreeSet 和  LinkedHashSet 都是set类型,输出显示在Set中,每个相同的
 * 项只能保存一次(不重复),但是输出也显示了不同的Set实现存储元素的方式不同.
 * 			HashSet 使用的是相当复杂的方式来存储元素的,这种技术是最快的获取元素的方式. 如果存储顺序
 * 很重要,那么可以使用TreeSet,它按照比较结果的升序保存元素.或者使用LinkedHashSet,它按照被添加的
 * 顺序保存元素.
 * 		5.关联数组:  HashMap, TreeMap 和 LinkedHashMap.
 * 			与HashSet一样,HashMap也提供了最快的查找技术,也没有按照任何明显的顺序来保存 元素.
 * 			TreeMap按照比较结果的升序保存键,而LinkedHashMap则按照插入顺序保存键,同事还保留了HashMap
 * 的查询速度.
 * 
 * @author admin
 *
 */
public class PrintingContainers {
	static Collection<String> fill(Collection<String> collection) {
		collection.add("rat");
		collection.add("cat");
		collection.add("dog");
		collection.add("dog");
		return collection;
	}
	
	static Map<String, String> fill(Map<String,String> map) {
		map.put("rat", "Fuzzy");
		map.put("cat", "Rags");
		map.put("dog", "Bosco");
		map.put("dog", "spot");
		return map;
	}
	
	public static void main(String[] args) {
		print(fill(new ArrayList<String>()));
		print(fill(new LinkedList<String>()));
		
		print(fill(new HashSet<String>()));
		print(fill(new TreeSet<String>()));
		print(fill(new LinkedHashSet<String>()));
		
		print(fill(new HashMap<String,String>()));
		print(fill(new TreeMap<String,String>()));
		print(fill(new LinkedHashMap<String,String>()));
		
		/**
		 * [rat, cat, dog, dog]
			[rat, cat, dog, dog]
			[cat, dog, rat]
			[cat, dog, rat]
			[rat, cat, dog]
			{cat=Rags, dog=spot, rat=Fuzzy}
			{cat=Rags, dog=spot, rat=Fuzzy}
			{rat=Fuzzy, cat=Rags, dog=spot}

		 */
	}
}
