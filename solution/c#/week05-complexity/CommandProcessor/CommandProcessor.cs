namespace CommandProcessor
{
    public class CommandProcessor
    {
        private readonly Dictionary<string, ICommand> _commands = [];
        public IEnumerable<string> CommandsNames() => _commands.Keys;

        public void AddCommand(string commandName, ICommand command)
            => _commands[commandName] = command;

        public void ProcessCommand(string commandName, Action<string> printTo) =>
            printTo(_commands.TryGetValue(commandName, out var cmd)
                ? cmd.ExecuteAndDisplayResult()
                : "Command not recognized.");
    }
}