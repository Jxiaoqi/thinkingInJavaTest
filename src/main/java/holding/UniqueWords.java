package holding;

import java.io.File;
import java.util.Set;
import java.util.TreeSet;

import util.TextFile;

/**
 * p417
 * Set 	
 * 		能够产生每个元素都唯一的列表是相当有用的功能.
 * 		1.了解TextFile功能,很好,
 * 		2.在本例中,排序是按照"字典序" 进行的,因此大写和小写被划分到了不同的组中.如果你想要
 * 按照"字母序" 排序,那么可以向TreeSet的构造器穿入 String.CASE_INSENTIVE_ORDER比较器(
 * 比较器就是建立排序顺序的对象) 见: UniqueWordsAlphabetic.java
 * @author admin
 *
 */
public class UniqueWords {
	public static void main(String[] args) {
		Set<String> words = new TreeSet<String>(
				new TextFile("src"+ File.separator + 
						"holding"+ File.separator +
						"SetOperations.java", "\\W+"));
		System.out.println(words);
	}
}
