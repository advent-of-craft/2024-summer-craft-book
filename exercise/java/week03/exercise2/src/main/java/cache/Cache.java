package cache;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    private Map<String, Integer> map = new HashMap<String, Integer>();

    public int getOrInsert(String key, int value) {
        if (!map.containsKey(key)) {
            map.put(key, value);
        }
        return map.get(key); // Modifies state if key not present and returns value
    }
}
