package holding;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  * Map containsKey 遇到的问题
 *  *   不能复现在
 *  * @author xiaoqi
 *  * @since 11 七月 2018
 *  
 */
public class MapContainsKeyTest {

    public static void main (String[] args) {

        Map<Integer, String> integerStringHashMap = new HashMap<>(10);
        integerStringHashMap.put(1, "1");
        integerStringHashMap.put(2, "2");
        integerStringHashMap.put(3, "3");

        integerStringHashMap.put(16977, "16977");
        integerStringHashMap.put(Integer.valueOf(16978), "16978");

        System.out.println("是否包含 1：" + integerStringHashMap.containsKey(1));
        System.out.println("是否包含Integer 1 " + integerStringHashMap.containsKey(Integer.valueOf(1)));

        System.out.println("是否包含 16977：" + integerStringHashMap.containsKey(16977));
        System.out.println("是否包含 Integer 16977 " + integerStringHashMap.containsKey(Integer.valueOf(16977)));

        System.out.println("是否包含 16978：" + integerStringHashMap.containsKey(16978));
        System.out.println("是否包含 Integer 16978 " + integerStringHashMap.containsKey(Integer.valueOf(16978)));
        System.out.println("是否包含 String 16978 " + integerStringHashMap.containsKey(Integer.valueOf(16978).toString()));



    }
}
