package holding;

import java.util.List;
import java.util.ListIterator;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

/**
 *  ListIterator
 *  	1.ListIterator是一个更加强大的Interator的子类型,它只能用于各种 List类的访问.
 *  Iterator只能向前移动,但是ListIterator可以双向移动.
 *  	它可以产生相对于迭代器在列表中指向的当前位置的前一个和后一个元素的索引(.next(), .previous())
 *  并且可以使用set()方法替换它访问过的最后一个元素.
 *  	可以使用ListIterator(n)方法创建一个一开始就指向列表索引n的 元素处的ListIterator.
 * @author admin
 *
 */
public class ListIteration {
	public static void main(String[] args) {
		List<Pet> pets = Pets.arrayList(8);
		ListIterator<Pet> it = pets.listIterator();
		while (it.hasNext()) {
			System.out.print(it.next() + ", " + it.nextIndex() + 
					", " + it.previousIndex() + "; ");
		}
		System.out.println();
		//Backwards
		while (it.hasPrevious()) {
			System.out.print(it.previous().id() + " ");
		}
		
		System.out.println();
		System.out.println(pets);
		it = pets.listIterator(3);
		while (it.hasNext()) {
			Pet p = (Pet) it.next();
			it.set(Pets.randomPet());
		}
		System.out.println(pets);
	}
}
