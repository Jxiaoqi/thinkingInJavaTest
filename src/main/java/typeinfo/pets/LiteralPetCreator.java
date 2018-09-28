//: typeinfo/pets/LiteralPetCreator.java
// Using class literals.
package typeinfo.pets;

import com.google.common.collect.Lists;

import java.util.*;

public class LiteralPetCreator extends PetCreator {

    public static final List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(Arrays.asList(
            Pet.class, Dog.class, Cat.class, Rodent.class,
            Mutt.class, Pug.class, EgyptianMau.class, Manx.class,
            Cymric.class, Rat.class, Mouse.class, Hamster.class));

    private static final List<Class<? extends Pet>> types =
            allTypes.subList(allTypes.indexOf(Mutt.class), allTypes.size());



    @Override
    public List<Class<? extends Pet>> types () {
        return allTypes;
    }

    public static void main (String[] args) {
        System.out.println(new LiteralPetCreator().types());
        new LiteralPetCreator().types().add(Pet.class);
    }
} /* Output:
[class typeinfo.pets.Mutt, class typeinfo.pets.Pug, class typeinfo.pets.EgyptianMau, class typeinfo.pets.Manx, class typeinfo.pets.Cymric, class typeinfo.pets.Rat, class typeinfo.pets.Mouse, class typeinfo.pets.Hamster]
*///:~
