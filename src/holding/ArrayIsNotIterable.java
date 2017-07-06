package holding;

import java.util.Arrays;

/**
 * foreach 和  迭代器
 * 		foreach迭代器可以用于数组或其他任何 Iterable,但是这并不意味着数组肯定也是一个Iterable,
 * 而任何自动包装也不会自动发生; 
 * 		尝试把数组当做一个Iterable参数传递会导致失败.这说明不存在任何从数组到Iterable的自动转换,
 * 你必须手工执行这些转换.
 * @author admin
 *
 */
public class ArrayIsNotIterable {
	static <T> void test(Iterable<T> ib) {
		for (T t : ib) {
			System.out.print(t + " ");
		}
	}
	
	public static void main(String[] args) {
		test(Arrays.asList(1, 2, 3, 4));
		String[] strings = {"a",  "b", "c"};
		//The method test(Iterable<T>) in the type ArrayIsNotIterable is not applicable for the arguments (String[])
		//An array works in foreache, but it's not Iterable:
		//!test(strings);
		//you must explicitly convert it in to an Iterable:
		test(Arrays.asList(strings));
	}
}
