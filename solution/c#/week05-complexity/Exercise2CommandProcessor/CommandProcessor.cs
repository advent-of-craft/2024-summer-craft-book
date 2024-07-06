namespace Command;

public class CommandProcessor
{
    private readonly Dictionary<string, ICommand> commands = [];

    public IEnumerable<string> GetCommandsNames()
    {
        return commands.Keys;
    }

    public void AddCommand(string commandName, ICommand command)
    {
        commands[commandName] = command;
    }

    public void ProcessCommand(string commandName, Action<string> printTo)
    {
        if (commands.TryGetValue(commandName, out var cmd))
        {
            printTo(cmd.ExecuteAndDisplayResult());
        }
        else
        {
            printTo("Command not recognized.");
        }
    }
}