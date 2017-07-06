package holding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import typeinfo.pets.Cat;
import typeinfo.pets.Cymric;
import typeinfo.pets.Dog;
import typeinfo.pets.Mutt;
import typeinfo.pets.Person;
import typeinfo.pets.Pet;
import typeinfo.pets.Pug;
import typeinfo.pets.Rat;
import static util.Print.*;

/**
 * Map
 * 		Map可以返回它的键的set(keySet()), 它的值的Collection(values()),
 * 后者它的键值对的set(entrySet())
 * @author admin
 *
 */
public class MapOfList {
		public static Map<Person, List<? extends Pet>> 
			petPeople = new HashMap<Person, List<? extends Pet>>();
		static {
			petPeople.put(new Person("Dawn"), 
					Arrays.asList(new Cymric("Molly"), new Mutt("Spot")));
			petPeople.put(new Person("Kate"), 
					Arrays.asList(new Cat("Shackleton"), new Cat("Elisie May"), 
							new Dog("Margrett")));
			petPeople.put(new Person("Marilyn"), 
					Arrays.asList(
							new Pug("Louie aka louis Snorkelstein Dupree"), 
							new Cat("Stanford aks singky el Negro"), 
							new Cat("Pinkola")));
			petPeople.put(new Person("Luke"), 
					Arrays.asList(new Rat("Fuzzy"), new Rat("Fizzy")));
		}
		
		public static void main(String[] args) {
			print("People: " + petPeople.keySet());
			print("Pets: " + petPeople.values());
			for (Person person : petPeople.keySet()) {
				print(person + " has:");
				for (Pet pet : petPeople.get(person)) {
					print("    " + pet);
				}
			}
		}
		
		/**
		 * People: [Person Marilyn, Person Luke, Person Kate, Person Dawn]
Pets: [[Pug Louie aka louis Snorkelstein Dupree, Cat Stanford aks singky el Negro, Cat Pinkola], [Rat Fuzzy, Rat Fizzy], [Cat Shackleton, Cat Elisie May, Dog Margrett], [Cymric Molly, Mutt Spot]]
Person Marilyn has:
    Pug Louie aka louis Snorkelstein Dupree
    Cat Stanford aks singky el Negro
    Cat Pinkola
Person Luke has:
    Rat Fuzzy
    Rat Fizzy
Person Kate has:
    Cat Shackleton
    Cat Elisie May
    Dog Margrett
Person Dawn has:
    Cymric Molly
    Mutt Spot

		 */
}
