namespace Cache
{
    public class Cache
    {
        private readonly Dictionary<string, int> _map = new();

        public int GetOrInsert(string key, int value)
        {
            if (!_map.ContainsKey(key))
            {
                _map[key] = value;
            }

            return _map[key];
        }
    }
}