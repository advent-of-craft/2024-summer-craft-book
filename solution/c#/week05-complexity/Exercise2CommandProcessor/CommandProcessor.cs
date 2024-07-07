namespace Exercise2CommandProcessor
{
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
        printTo(
            commands.TryGetValue(commandName, out var cmd)
                ? cmd.ExecuteAndDisplayResult()
                : "Command not recognized.");
    }
    }
}