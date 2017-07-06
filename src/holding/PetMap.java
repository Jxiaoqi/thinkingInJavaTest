package holding;

import java.util.HashMap;
import java.util.Map;

import typeinfo.pets.Cat;
import typeinfo.pets.Dog;
import typeinfo.pets.Hamster;
import typeinfo.pets.Pet;

/**
 * Map
 * 	containsKey();
 * 	containsValue();
 * @author admin
 *
 */
public class PetMap {
	public static void main(String[] args) {
		Map<String, Pet> petMap = new HashMap<String, Pet>();
		petMap.put("My cat", new Cat("Molly"));
		petMap.put("My Dog", new Dog("Ginger"));
		petMap.put("My hamster", new Hamster("Bosco"));
		System.out.println(petMap);
		
		Pet dog = petMap.get("My Dog");
		System.out.println(dog);
		System.out.println(petMap.containsKey("My Dog"));
		System.out.println(petMap.containsValue(dog));
		
		/**
		 * {My hamster=Hamster Bosco, My Dog=Dog Ginger, My cat=Cat Molly}
			Dog Ginger
			true
			true
		 */
	}
}
