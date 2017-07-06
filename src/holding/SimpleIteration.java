package holding;

import java.util.Iterator;
import java.util.List;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

/**
 * 迭代器(也是一种设计模式)
 * 		1.迭代器是一个对象,它的工作是遍历并选择序列中的对象,而客户端程序员不必知道或关心
 * 该序列底层的结构.此外,迭代器通常被称为轻量级对象: 创建它的代价小.因此,经常可以见到对迭代器
 * 有些奇怪的限制;
 * 		2.Java的Iterator只能单向移动,这个Iterator只能用来:
 * 			1)使用方法iterator()要求容器返回一个Iterator.Iterator将准备好返回序列的第一个对象.
 * 			2)使用next()获得序列中的下一个对象.
 * 			3)使用hasNext()检查序列中是否还有元素.
 * 			4)使用remove()将迭代器新近返回的元素删除.
 * 		3.Iterator还可以移除有next()产生的最后一个元素,这意味着在调用remove()之前必须点调用next()
 * @author admin
 *
 */
public class SimpleIteration {
	public static void main(String[] args) {
		List<Pet> pets = Pets.arrayList(12);
		Iterator<Pet> it = pets.iterator();
		while (it.hasNext()) {
			Pet p = it.next();
			System.out.print(p.id() + ":" + p + " ");
		}
		System.out.println();
		
		for (Pet p : pets) 
			System.out.print(p.id() + ":" + p + " ");
		System.out.println();
		
		it = pets.iterator();
		for (int i = 0; i < 6; i++) {
			it.next();
			it.remove();
		}
		System.out.println(pets);
	}

}
