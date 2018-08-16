package holding;

import java.util.HashMap;
import java.util.Map;

/**
 *  * Map.values() 方法 to Map
 *  *
 *  * @author xiaoqi
 *  * @since 06 六月 2018
 *  
 */
public class Map2MapTest {

    public static void main (String[] args) {

        Map<String, Map<String, String>> shelfs = new HashMap<>(16);

        Map<String, String> displays = new HashMap<>(16);
        displays.put("1", "a");
        displays.put("2", "b");
        displays.put("3", "c");

        shelfs.put("A", displays);

    }
}
