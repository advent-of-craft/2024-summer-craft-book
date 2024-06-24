package cache

class Cache {
    private var map: MutableMap<String, Int> = HashMap()

    fun getOrInsert(key: String, value: Int): Int {
        if (!map.containsKey(key)) {
            map[key] = value
        }
        return map[key]!!
    }
}