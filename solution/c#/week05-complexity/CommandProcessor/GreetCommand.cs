namespace CommandProcessor
{
    public class GreetCommand(string firstName, string lastName) : ICommand
    {
        public string ExecuteAndDisplayResult() => $"Hello, {firstName} {lastName}!";
    }
}