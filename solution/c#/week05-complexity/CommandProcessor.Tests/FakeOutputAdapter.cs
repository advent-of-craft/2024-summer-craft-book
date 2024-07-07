using LanguageExt;

namespace CommandProcessor.Tests
{
    public class FakeOutputAdapter
    {
        private Lst<string> _allOutputs = Lst<string>.Empty;

        public string AllOutputs() => string.Join("\n", _allOutputs);

        public void SendOut(string message) => _allOutputs = _allOutputs.Add(message);
    }
}