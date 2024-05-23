package cache;

import java.util.HashMap;
import java.util.Map;

public class Cache {
    private final Map<String, Integer> map = new HashMap<>();

    public Integer get(String key) {
        return map.get(key); // Just returns the value or null if not present
    }

    public void insertIfAbsent(String key, int value) {
        map.putIfAbsent(key, value); // Only modifies the state, does not return value
    }

    public int ensurePresentAndGet(String key, int defaultValue) {
        insertIfAbsent(key, defaultValue);
        return get(key);
    }
}
