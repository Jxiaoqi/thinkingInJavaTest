package typeinfo.pets;


import static util.Print.*;

/**
 * TODO completion javadoc.
 *
 * @author xiaoqi
 * @since 28 八月 2018
 */
public class PetCount4 {

    public static void main (String[] args) {
        TypeCounter typeCounter = new TypeCounter(Pet.class);
        for (Pet pet : Pets.createArray(20)) {
            printnb(pet.getClass().getSimpleName() + " ");
            typeCounter.count(pet);
        }
        print();
        printnb(typeCounter);
    }
}
