package holding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

/**
 * 迭代器:    创建一个display方法,它不必知道容器的确切类型.
 * 		display()方法不包含任何有关它所遍历的序列的确切类型,而这也展示了Iterator的真正
 * 威力: 能够将遍历序列的操作与序列底层的结构分离.正由于此,我们有时会说:  迭代器统一了对容器的访问方式.
 * @author admin
 *
 */
public class CrossContainerIteration {
	public static void display(Iterator<Pet> it) {
		while (it.hasNext()) {
			Pet p = (Pet) it.next();
			System.out.print(p.id() + ":" + p + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		ArrayList<Pet> pets = Pets.arrayList(12);
		LinkedList<Pet> petsll = new LinkedList<Pet>(pets);
		HashSet<Pet> peths = new HashSet<Pet>(pets);
		TreeSet<Pet> petts = new TreeSet<Pet>(pets);
		display(pets.iterator());
		display(petsll.iterator());
		display(peths.iterator());
		display(petts.iterator());
		
	}
}
