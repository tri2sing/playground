package random;

import java.util.HashMap;
import java.util.Map;

public class StaticMemberNewInstance {
    private static Map<Integer, Integer> map = new HashMap();

    public static void insert(Integer key, Integer val) {
        map.put(key, val);
    }

    public static Integer retrieve(Integer key) {
        return map.get(key);
    }
}
