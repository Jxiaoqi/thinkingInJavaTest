package polymorphism;

import com.book.java8feature.Apple;
import com.book.java8feature.Fruit;
import com.book.java8feature.Strawberry;

/**
 *  *
 *  *   http://www.mamicode.com/info-detail-491367.html
 *  * @author xiaoqi
 *  * @since 27 十二月 2017
 *  
 */
public class PECSTest1 {

    public static void main (String[] args) {

//        //? extends
//        List<Apple> apples = new ArrayList<>();
//        List<? extends Fruit> fruits = apples;
//        //add (capture<? extends Friuit> in List cannot be applied  to Strawberry)
//        //fruits.add(new Strawberry());
//        Fruit friuit = fruits.get(0);
//
//        //? super
//        List<Fruit> fruits1 = new ArrayList<>();
//        List<? super Fruit> fruit11 = fruits1;
//        fruit11.add(new Apple());
//
//
//        //fruit11.add(new Object());
        int a = 2<<3;
        System.out.println(a);

        int num = 1;
        num <<=3;
        System.out.println(num);



    }

}
