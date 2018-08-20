package typeinfo;

import java.util.ArrayList;
import java.util.List;

/**
 *  * TODO completion javadoc.
 *  *
 *  * @author xiaoqi
 *  * @since 21 八月 2018
 *  
 */

class CountedInteger {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString () {
        return Long.toString(id);
    }
}

public class FilledList<T> {
    private Class<T> type;

    public FilledList (Class<T> type) {
        this.type = type;
    }

    public List<T> create (int nElements) {
        List<T> result = new ArrayList<>();
        for (int i = 0; i < nElements; i++) {
            try {
                result.add(type.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return result;
    }

    public static void main (String[] args) {
        FilledList<CountedInteger> filledList = new FilledList<>(CountedInteger.class);
        System.out.println(filledList.create(15));

//        CountedInteger countedInteger = new CountedInteger();
//        System.out.println(countedInteger);
    }
}
