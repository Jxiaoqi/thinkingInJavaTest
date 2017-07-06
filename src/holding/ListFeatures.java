package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import typeinfo.pets.Cymric;
import typeinfo.pets.Hamster;
import typeinfo.pets.Mouse;
import typeinfo.pets.Pet;
import typeinfo.pets.Pets;
import static util.Print.*;


/**
 * List
 * 		1.List的contains(), indexOf(T t), remove(T t)方法时,都会用到
 * equals()方法(String 的equals()方法已经被重写),因此,为了防止意外,就必须意识到
 * List的行为根据equals()的行为而有所变化.
 * 		2.在List中间插入元素是可行的,但是也带来了一个问题:
 * 			对于LinkedList,在列表中间插入和删除元素都是廉价操作.但是对于ArrayList,
 * 这可是代价高昂的操作.
 * 		3.subList()
 * 			subList()方法用来截取List,但是subList()所产生的的列表的幕后就是初始
 * 列表,因此,对所返回的列表的修改都会反映在初始列表中,反之亦然.
 * 		4.retainAll() 方法是一种有效的"交集"操作,所产生的行为依赖于equals()方法.
 * 		5.removeAll()方法也是基于equals()方法.
 * 		6.Collection.addAll() 和List.addAll()
 * 			对于List,有一个重载的addAll()方法使得我们可以在初始化List的中间插入新的列表,
 * 而不仅仅只能用Collection中的addAll()方法将其追加到表尾.
 * 		7.Collections.shuffle() ,穿入一个集合,和一个随机因子,来对列表重新洗牌.
 * 		8.Object[] toArray() 和  T[] toArray(T[] t)
 * 			你可以通过使用toArray()方法,将任意的Collection转换为一个数组.这是一个重载
 * 方法,其无参数版本返回的是一个Object[]数组.
 * 			向这个重载版本传递目标类型的数据,那么它将产生指定类型的数据(假设它能通过类型检查),
 * 如果参数数组太小,存放不下List中的所有元素,toArray()方法将创建一个具有合适尺寸的数组.
 * 
 * 		
 * 			
 * @author admin
 *
 */
public class ListFeatures {
	public static void main(String[] args) {
		Random rand = new Random(47);
		List<Pet> pets = Pets.arrayList(7);
		print("1: " + pets);
		
		Hamster h = new Hamster();		//Automatically resizes
		pets.add(h);
		print(pets);
		print(pets.contains(h));
		pets.remove(h);					//Remove by object
		
		Pet p = pets.get(2);
		print("4: " + p + " " + pets.indexOf(p));
		
		Pet cymric = new Cymric();		
		print("5: " + pets.indexOf(cymric));
		print("6: " + pets.remove(cymric));
		//must be the exact object:
		print("7 " + pets.remove(p));
		print("8 " + pets);
		
		pets.add(3, new Mouse());		//insert in an index
		print("9: " + pets);
		
		List<Pet> sub = pets.subList(1, 4);
		print("sublist: " + sub);		//含头不含尾
		print("10: " + pets.containsAll(sub));
		Collections.sort(sub); 			//In-place sort
		print("Sorted sublist: " + sub);
		print("11: " + pets.containsAll(sub));
		Collections.shuffle(sub,rand);		//mix it up
		print("shuffled sublist: " + sub);
		print("12: " + pets.containsAll(sub));
		
		
		List<Pet> copy = new ArrayList<Pet>(pets);
		sub = Arrays.asList(pets.get(1), pets.get(4));
		print("sub: " + sub);
		
		copy.retainAll(sub);	//删除掉copy中不包含sub的其他元素
		print("13: " + copy);
		
		copy = new ArrayList<Pet>(pets);		//get a fresh copy
		System.out.println("copy: " + copy);
		copy.remove(2);
		print("14: " + copy);
		print("sub: " + sub);
		copy.removeAll(sub);		//only removes exact objects
		print("15: " + copy);
		
		copy.set(1, new Mouse());	//replace an element
		print("16: " + copy);
		
		copy.addAll(2,sub);
		print("17: " + copy);
		print("18: " + pets.isEmpty());
		pets.clear();				//remove all elements
		print("19: " + pets);
		print("20: " + pets.isEmpty());
		
		pets.addAll(Pets.arrayList(4));
		print("21: " + pets);
		
		Object[] o = pets.toArray();
		print("22: " + o[3]);
		
		Pet[] pa = pets.toArray(new Pet[0]);
		print(pa);
		print("23: " + pa[3].id());
		
		
		
		
	}
}
