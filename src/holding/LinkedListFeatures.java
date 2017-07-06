package holding;

import java.util.LinkedList;

import typeinfo.pets.Hamster;
import typeinfo.pets.Pet;
import typeinfo.pets.Pets;
import typeinfo.pets.Rat;
import static util.Print.*;

/**
 * LinkedList
 * 		1.LinkedList也像ArrayList一样实现了基本的List接口,但是它执行某些操作(在List
 * 中间插入和移除)时比ArrayList更高效,但在随机访问操作方面却要逊色一些.
 * 		2.LinkedList还添加了可以使其用作 栈 、队列、和双端队列的方法。
 * 			getFirst 和element完全一样,它们都返回列表的头.而并不移除它,如果List为空,则抛出
 * 		noSuchElementException. peek()方法与这两个方法也是稍有差异,它在列表为空时返回null
 * 			removeFirst() 与remove()也是完全一样,它们移除并返回列表的头,而在列表为空时抛出
 * 		NoSuchElementException. poll()稍有差异,它在列表为空时返回null;
 * 			addFirst()  add()  addLast() 相同,它们都将某个元素插入到列表的尾(端)部.
 * 			removeLast()移除并返回列表的最后一个元素.
 * @author admin
 *
 */
public class LinkedListFeatures {
	public static void main(String[] args) {
		LinkedList<Pet> pets = 
				new LinkedList<Pet>(Pets.arrayList(5));
		print(pets);
		
		print("pets.getFirst(): " + pets.getFirst());
		print("pets.element(): " + pets.element());
		//Only differ in empty-list behavior
		print("pets.peek(): " + pets.peek());      //列表为空时返回null
		
		print("pets.remove(): " + pets.remove());
		print("pets.removeFirst(): " + pets.removeFirst());
		//Only differ in empty-list behavior
		print("pets.poll(): " + pets.poll());		//列表为空时返回null
		print(pets);
		
		pets.addFirst(new Rat());
		print("After addFirst(): " + pets);
		pets.offer(Pets.randomPet());
		print("After offer(): " + pets);
		pets.add(Pets.randomPet());
		print("After add(): " + pets);
		
		pets.addLast(new Hamster());
		print("After addLast(): " + pets);
		print("pets.removeLast(): " + pets.removeLast());
		
	}
	
}
