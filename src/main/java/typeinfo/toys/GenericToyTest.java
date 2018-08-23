package typeinfo.toys;

/**
 *  * TODO completion javadoc.
 *  *
 *  * @author xiaoqi
 *  * @since 21 八月 2018
 *  
 */
public class GenericToyTest {

    public static void main (String[] args) throws IllegalAccessException, InstantiationException {
        Class<FactoryToy> factoryToyClass = FactoryToy.class;
        FactoryToy factoryToy = factoryToyClass.newInstance();
        Class<? super FactoryToy> superclass = factoryToyClass.getSuperclass();
       // this won't compile
        //Class<Toy> up2 = factoryToyClass.getSuperclass();
        superclass.newInstance();
    }
}
