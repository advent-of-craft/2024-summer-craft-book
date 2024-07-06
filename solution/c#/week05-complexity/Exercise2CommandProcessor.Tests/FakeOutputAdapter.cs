using LanguageExt;

namespace Exercise2CommandProcessor.Tests;

public class FakeOutputAdapter
{
    private Lst<string> allOutputs = Lst<string>.Empty;

    public string GetAllOutputs()
    {
        return string.Join("\n", allOutputs);
    }

    public void SendOut(string message)
    {
        allOutputs = allOutputs.Add(message);
    }

}