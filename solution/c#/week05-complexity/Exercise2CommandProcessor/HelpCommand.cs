namespace Command;

public class HelpCommand(HashSet<string> commandsName) : ICommand
{
    public string ExecuteAndDisplayResult()
    {
        var result = "Here are all the available commands:\n";
        result += string.Join("\n", commandsName);
        return result;
    }
}