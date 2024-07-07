namespace CommandProcessor
{
    public class CommandProcessor
    {
        private readonly Dictionary<string, ICommand> _commandMap = new();

        public CommandProcessor()
        {
            _commandMap["greet"] = new ActionCommand(() => Console.WriteLine("Hello, World!"));
            _commandMap["exit"] = new ActionCommand(() => Console.WriteLine("Exiting application..."));
        }

        public void ProcessCommand(string command)
        {
            if (_commandMap.ContainsKey(command))
            {
                _commandMap[command]?.Execute();
            }
            else
            {
                Console.WriteLine("Unknown command");
            }
        }
    }

    public class ActionCommand(Action action) : ICommand
    {
        public void Execute() => action();
    }
}