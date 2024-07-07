namespace CommandProcessor
{
    public class ExitCommand : ICommand
    {
        public string ExecuteAndDisplayResult() => "Goodbye!";
    }
}