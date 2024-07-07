namespace Cache
{
    public class Cache
    {
        private readonly Dictionary<string, int> _map = new();

        public int? Get(string key)
        {
            _map.TryGetValue(key, out var value);
            return value;
        }

        public void InsertIfAbsent(string key, int value)
        {
            if (!_map.ContainsKey(key))
            {
                _map[key] = value;
            }
        }

        public int EnsurePresentAndGet(string key, int defaultValue)
        {
            InsertIfAbsent(key, defaultValue);
            return Get(key) ?? defaultValue;
        }
    }
}