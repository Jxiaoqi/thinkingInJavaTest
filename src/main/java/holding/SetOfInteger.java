package holding;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 
 * Set   ----p415
 * 		1.Set保存不重复元素.
 * 			如果你试图将相同对象的多个实例添加到Set中,那么它就会阻止这种重复现象.Set中
 * 最常被使用的是测试归属性,你可以很容易地询问某个对象是否在某个Set中.正因为如此,查找就成为了
 * Set最重要的操作,因为你通常会选择一个HashSet的实现,它专门快速查找进行了优化.
 * 		2.Set 与 Collection完全一样的接口,因此没有任何额外的功能.实际上Set就是Collection,
 * 只是行为不同(这是继承与多态的典型应用:表现不同的行为).Set是基于对象的值来确定归属性的.
 * 		3. Set集合的输出没有任何规律可循,这是因为出于速度原因的考虑,HashSet使用了散列.
 * HashSet所维护的顺序与 TreeSet 或 LinkedHashSet 都不同,因为他们的实现具有不同的元素存储方式.
 * TreeSet将元素存储在  红-黑树数据结构中,而HashSet使用的是散列函数. LinkedHashList因为查询
 * 速度的原因也使用了散列,但是看起来它使用了链表来维护元素的插入顺序.
 * @author admin
 *
 */
public class SetOfInteger {
	public static void main(String[] args) {
		Random rand = new Random(47);
		Set<Integer> intSet = new HashSet<Integer>();
		for (int i = 0; i < 10000; i++) {
			intSet.add(rand.nextInt(30));
		}
		System.out.println(intSet);
		/**
		 * [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 16, 19, 18, 21, 20, 23, 22, 25, 24, 27, 26, 29, 28]
		 */
	}
}
