package cache

class Cache {
    private val map: MutableMap<String, Int> = mutableMapOf()

    fun get(key: String): Int? = map[key] // Just returns the value or null if not present

    fun insertIfAbsent(key: String, value: Int) {
        map.putIfAbsent(key, value) // Only modifies the state, does not return value
    }

    fun ensurePresentAndGet(key: String, defaultValue: Int): Int {
        insertIfAbsent(key, defaultValue)
        return get(key) ?: defaultValue
    }
}
