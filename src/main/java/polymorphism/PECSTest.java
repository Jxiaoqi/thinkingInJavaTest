package polymorphism;

import java.util.*;

/**
 *  *  什么是PECS？PECS指“Producer Extends，Consumer Super”。
 *     换句话说，如果参数化类型表示一个生产者，就使用<? extends T>；如果它表示一个消费者，就使用<? super T>。
 *
 *     总结：
        1、如果你是想遍历collection，并对每一项元素操作时，此时这个集合时生产者（生产元素），应该使用 Collection<? extends Thing>
        2、如果你是想添加元素到collection中去，那么此时集合时消费者（消费元素）应该使用Collection<? super Thing>

 *          http://blog.csdn.net/bigtree_3721/article/details/42054465
 *
 *  * @author xiaoqi
 *  * @since 27 十二月 2017
 *  
 */
public class PECSTest<E> {

    private List<E> list = new ArrayList<>();

    public E pop() {
        return list.get(0);
    }

    /**
     * 假设有个Stack<Number>，想要灵活的处理Integer，Long等Number的子类型的集合
     * @param src
     */
    public void pushAll(Iterable<E> src) {
        for (E e : src) {
            list.add(e);
        }
    }

    /**
     * java提供了一种叫有限通配符的参数化类型，pushAll参数替换为“E的某个子类型的Iterable接口”
     * 这里的<? extends E>就是所谓的 producer-extends。这里的Iterable就是生产者，要使用<? extends E>。
     * 因为Iterable<? extends E>可以容纳任何E的子类。在执行操作时，可迭代对象的每个元素都可以当作是E来操作。
     * @param src
     */
    public void pushAll2(Iterable<? extends E> src) {
        for (E e : src) {
            list.add(e);
        }
    }

    public void popAll(Collection<E> objects) {
        if (!list.isEmpty()) {
            objects.add(pop());
        }
    }

    public void popAll2(Collection<? super E> objects) {
        if (!list.isEmpty()) {
            objects.add(pop());
        }
    }


    public static void main (String[] args) {
        PECSTest<Number> numberPECSTest = new PECSTest<>();
        Iterable<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        //此时代码编译无法通过，因为对于类型Number和Integer来说，虽然后者是Number的子类，
        // 但是对于任意Number集合（如 List<Number>）不是Integer集合（如List<Integer>）的超类，因为泛型是不可变的。
        //numberPECSTest.pushAll(integers);

        numberPECSTest.pushAll2(integers);

        Collection<Object> objects = new ArrayList<>();
        //同样上面这段代码也无法通过，解决的办法就是使用Collection<? super E>。
        // 这里的objects是消费者，因为是添加元素到objects集合中去。使用Collection<? super E>后，
        // 无论objects是什么类型的集合，满足一点的是他是E的超类，所以不管这个参数化类型具体是什么类型都能将E装进objects集合中 去。
        //numberPECSTest.popAll(objects);
        numberPECSTest.popAll2(objects);

    }


}
