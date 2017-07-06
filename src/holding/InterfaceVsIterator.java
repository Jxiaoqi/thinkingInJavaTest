package holding;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

/**
 * Collection 和 Iterator p428
 * @author admin
 *
 */
public class InterfaceVsIterator {

	public static void display(Iterator<Pet> it) {
		while (it.hasNext()) {
			Pet p = it.next();
			System.out.print(p.id() + ": " + p + " ");
		}
		System.out.println();
	}
	
	public static void display(Collection<Pet> pets) {
		for (Pet p : pets) 
			System.out.print(p.id() + ": " + p + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		List<Pet> petList = Pets.arrayList(8);
		Set<Pet> petSet = new HashSet<Pet>();
		Map<String, Pet> petMap = 
				new HashMap<String, Pet>();
		String[] names = ("Ralph, Eric, Robin, Lacey, "+
				"Britney, Sam, Spot, Fluffy").split(", ");
		for (int i = 0; i < names.length; i++) 
			petMap.put(names[i], petList.get(i));
		display(petList);
		display(petSet);
		display(petList.iterator());
		display(petSet.iterator());
		System.out.println(petMap);
		System.out.println(petMap.keySet());
		display(petMap.values());
		display(petMap.values().iterator());
		
		/**
		 * 0: Rat 1: Manx 2: Cymric 3: Mutt 4: Pug 5: Cymric 6: Pug 7: Manx 

0: Rat 1: Manx 2: Cymric 3: Mutt 4: Pug 5: Cymric 6: Pug 7: Manx 

{Britney=Pug, Lacey=Mutt, Fluffy=Manx, Sam=Cymric, Eric=Manx, Ralph=Rat, Robin=Cymric, Spot=Pug}
[Britney, Lacey, Fluffy, Sam, Eric, Ralph, Robin, Spot]
4: Pug 3: Mutt 7: Manx 5: Cymric 1: Manx 0: Rat 2: Cymric 6: Pug 
4: Pug 3: Mutt 7: Manx 5: Cymric 1: Manx 0: Rat 2: Cymric 6: Pug 
		 */
	}

}
