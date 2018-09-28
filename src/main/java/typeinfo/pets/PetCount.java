package typeinfo.pets;

import static util.Print.*;

import java.util.HashMap;
import java.util.Objects;

/**
 *  * TODO completion javadoc.
 *  *
 *  * @author xiaoqi
 *  * @since 25 八月 2018
 *  
 */
public class PetCount {

    static class PetCounter extends HashMap<String, Integer> {
        public void count (String type) {
            Integer quantity = get(type);
            if (Objects.isNull(quantity)) {
                put(type, quantity);
            } else {
                put(type, quantity + 1);
            }
        }

        public static void countPets (PetCreator petCreator) {
            PetCounter petCounter = new PetCounter();
            for (Pet pet : petCreator.createArray(20)) {
                printnb(pet.getClass().getSimpleName() + " ");
                if (pet instanceof Pet) {
                    petCounter.count("Pet");
                }
                if (pet instanceof Dog) {
                    petCounter.count("Dog");
                }
                if (pet instanceof Mutt) {
                    petCounter.count("Mutt");
                }
                if (pet instanceof Pug) {
                    petCounter.count("Pug");
                }
                if (pet instanceof Cat) {
                    petCounter.count("Cat");
                }
            }
            print();
            print(petCounter);
        }

        public static void main (String[] args) {
            countPets(new ForNameCreator());
        }
    }
}
