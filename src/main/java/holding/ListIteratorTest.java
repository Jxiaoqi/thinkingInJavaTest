package holding;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {

    public static void main(String[] args) {

        List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.add("S");
        stringList.add("J");
        stringList.add("v");

        ListIterator<String> listIterator = stringList.listIterator();
        String[] a = stringList.toArray(new String[stringList.size()]);
        for (String e : a) {
            System.out.println(listIterator.next());
        }
    }
}
